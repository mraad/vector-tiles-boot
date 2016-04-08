package com.esri

import scala.math._

/**
  * https://github.com/mapbox/mercantile
  */
final class Mercantile(tileSize: Int = 512) {

  val initialResolution = 2.0 * Pi * Mercantile.EARTH_RAD / tileSize

  def resolution(zoom: Int) = {
    initialResolution / (1 << zoom)
  }

  def scale(resolution: Double, dpi: Double = 96.0) = {
    resolution * dpi * Mercantile.INCHES_PER_METERS
  }

  def tileLonLat(zoom: Int, tx: Int, ty: Int) = {
    val n = (1 << zoom).toDouble
    val lon = 360.0 * tx.toDouble / n - 180.0
    val lat = toDegrees(atan(sinh(Pi * (1.0 - 2.0 * ty.toDouble / n))))
    (lon, lat)
  }

  def tileMercator(zoom: Int, tx: Int, ty: Int) = {
    val (lon, lat) = tileLonLat(zoom, tx, ty)
    (WebMercator.longitudeToX(lon), WebMercator.latitudeToY(lat))
  }
}

object Mercantile {
  val EARTH_RAD = 6378137.0
  val INCHES_PER_METERS = 39.0 + 3.0 / 8.0

  def apply() = new Mercantile()
}
