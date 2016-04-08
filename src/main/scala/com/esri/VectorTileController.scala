package com.esri

import javax.annotation.PostConstruct

import com.esri.core.geometry.{Envelope2D, Geometry, MultiPath}
import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation._
import org.springframework.web.context.request.WebRequest

import scala.collection.JavaConversions._

@RestController
@RequestMapping(Array("/arcgis/rest/services"))
class VectorTileController {

  val spatialReference = new SpatialReference("pcs", 102100, 3857)
  val mercator = Mercantile()

  var extent: Extent = _

  @Value("${num.lods:17}")
  var numLODs: Int = _

  @Value("${clip.factor:0.1}")
  var clipFactor: Double = _

  @Autowired
  var geoStore: GeoStore = _

  @PostConstruct
  def postConstruct() = {
    val (xmin, ymax) = mercator.tileMercator(0, 0, 0)
    val (xmax, ymin) = mercator.tileMercator(0, 1, 1)
    extent = new Extent(xmin, ymin, xmax, ymax, spatialReference)
  }

  @RequestMapping(
    method = Array(RequestMethod.GET, RequestMethod.POST),
    path = Array("/{name}/VectorTileServer"),
    produces = Array(MediaType.APPLICATION_JSON_VALUE)
  )
  @ResponseBody
  def doVectorTileServer(
                          webRequest: WebRequest,
                          @PathVariable("name") name: String
                        ) = {

    val scheme = if (webRequest.isSecure) "https" else "http"
    val hostPort = webRequest.getHeader("host")

    val vts = new VectorTileServer
    vts.name = name
    vts.fullExtent = extent
    vts.initialExtent = extent
    vts.minScale = Float.MaxValue
    vts.maxScale = 0.0
    vts.tiles = Array(s"$scheme://$hostPort/arcgis/rest/services/$name/VectorTileServer/tile/{z}/{x}/{y}.pbf")
    val tileInfo = new TileInfo
    tileInfo.origin = new Origin(extent.xmin, extent.ymax)
    tileInfo.spatialReference = spatialReference
    tileInfo.lods = (0 until numLODs map (lod => {
      val resolution = mercator.resolution(lod)
      val scale = mercator.scale(resolution)
      new LOD(lod, resolution, scale)
    })).toArray
    vts.tileInfo = tileInfo
    vts
  }

  // https://www.mapbox.com/mapbox-gl-style-spec/
  @RequestMapping(
    method = Array(RequestMethod.GET, RequestMethod.POST),
    path = Array("/{name}/VectorTileServer/styles"),
    produces = Array(MediaType.APPLICATION_JSON_VALUE)
  )
  @ResponseBody
  def doStyles(@PathVariable("name") name: String) = {
    val styles = new Styles()
    styles.sources = Map(name -> new Source(s"/arcgis/rest/services/$name/VectorTileServer"))
    styles.layers = Array[ILayer](
      new LayerBase("background", LayerType.BACKGROUND, new PaintBackground("#000000")),
      new LayerSource(name, "lines", LayerType.LINE, new PaintLine("#FFFFFF")),
      new LayerSource(name, "fills", LayerType.FILL, new PaintFill("#FFFFFF", 1.0F, "#FF0000"))
    )
    styles
  }

  // application/vnd.mapbox-vector-tile
  @RequestMapping(
    method = Array(RequestMethod.GET, RequestMethod.POST),
    path = Array("/{name}/VectorTileServer/tile/{z}/{x}/{y}.pbf"),
    produces = Array(MediaType.APPLICATION_OCTET_STREAM_VALUE)
  )
  @ResponseBody
  def doTile(
              @PathVariable("name") name: String,
              @PathVariable("z") z: Int,
              @PathVariable("x") x: Int,
              @PathVariable("y") y: Int
            ) = {

    val (xmin, ymax) = mercator.tileMercator(z, x, y)
    val (xmax, ymin) = mercator.tileMercator(z, x + 1, y + 1)

    val envp = new Envelope2D(xmin, ymin, xmax, ymax)
    val dx = (xmax - xmin) * clipFactor
    val dy = (ymax - ymin) * clipFactor
    val clip = new Envelope2D(xmin - dx, ymin - dy, xmax + dx, ymax + dy)

    val attr = Map[String, Any]()

    val vte = VectorTileEncoder(envp, clip)
    geoStore.query(envp, (geom: Geometry) => {
      vte.addFill("fills", geom.asInstanceOf[MultiPath], attr)
    })
    vte.encode()
  }

}
