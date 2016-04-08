package com.esri;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TileInfo implements Serializable
{
    public int rows = 512;

    public int cols = 512;

    public int dpi = 96;

    public String format = "pbf";

    public Origin origin;

    public SpatialReference spatialReference;

    public LOD[] lods;
}
