package com.esri

import org.scalatest._

/**
  */
class MercantileTest extends FlatSpec with Matchers {

  "tile (0,0,0)" should "cover the world" in {
    val mercantile = Mercantile()
    val (left, top) = mercantile.tileLonLat(0, 0, 0)
    left shouldBe -180.0
    (top > 85) shouldBe true

    val (right, buttom) = mercantile.tileLonLat(0, 1, 1)
    right shouldBe 180.0
    (buttom < -85) shouldBe true
  }

}
