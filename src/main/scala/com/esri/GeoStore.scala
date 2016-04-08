package com.esri

import java.io.BufferedInputStream
import java.util.zip.GZIPInputStream
import javax.annotation.PostConstruct

import com.esri.core.geometry.Geometry.GeometryAccelerationDegree
import com.esri.core.geometry.{SpatialReference => CoreSpatialReference, _}
import org.springframework.beans.factory.annotation.{Autowired, Value}
import org.springframework.core.io.ResourceLoader
import org.springframework.stereotype.Component

import scala.io.{Source => IOSource}

/**
  * QuadTree in esri.github.io/geometry-api-java/javadoc
  */
@Component
class GeoStore {

  @Value("${wkt.name:classpath:/admin.wkt.gz}")
  var resourceName: String = _

  @Value("${quadtree.xmin:-180.0}")
  var xmin: Double = _

  @Value("${quadtree.xmax:180.0}")
  var xmax: Double = _

  @Value("${quadtree.ymin:-89.0}")
  var ymin: Double = _

  @Value("${quadtree.ymax:89.0}")
  var ymax: Double = _

  @Value("${quadtree.depth:12}")
  var depth: Int = _

  @Value("${query.tolerance:0.1}")
  var tolerance: Double = _

  @Autowired
  var resourceLoader: ResourceLoader = _

  var quadTree: QuadTree = _

  var geomArr: Array[Geometry] = _

  @PostConstruct
  def postConstruct() = {
    xmin = WebMercator.longitudeToX(xmin)
    xmax = WebMercator.longitudeToX(xmax)
    ymin = WebMercator.latitudeToY(ymin)
    ymax = WebMercator.latitudeToY(ymax)
    quadTree = new QuadTree(new Envelope2D(xmin, ymin, xmax, ymax), depth)
    val resource = resourceLoader.getResource(resourceName)
    val inputStream = resource.getInputStream
    try {
      val gz = new GZIPInputStream(new BufferedInputStream(inputStream))
      val envelope = new Envelope2D()
      val wktReader = OperatorImportFromWkt.local()
      geomArr = IOSource.fromInputStream(gz)
        .getLines()
        .drop(1)
        .zipWithIndex
        .map {
          case (line, index) => {
            val tokens = line.split('\t')
            val geometry = wktReader.execute(
              WktImportFlags.wktImportDefaults,
              Geometry.Type.Polygon,
              tokens.last,
              null
            ).asInstanceOf[Polygon]
            wktReader.accelerateGeometry(geometry, null, GeometryAccelerationDegree.enumHot)
            geometry.queryEnvelope2D(envelope)
            quadTree.insert(index, envelope)
            geometry
          }
        }.toArray
    }
    finally {
      inputStream.close()
    }
  }

  def query(envelope: Envelope2D, geomFunc: (Geometry) => Unit): Unit = {
    val quadTreeIterator = quadTree.getIterator(envelope, tolerance)
    var internalIndex = quadTreeIterator.next
    while (internalIndex >= 0) {
      geomFunc(geomArr(quadTree.getElement(internalIndex)))
      internalIndex = quadTreeIterator.next
    }
  }

}
