package com.esri;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VectorTileServer implements Serializable
{
    public String currentVersion = "10.4";

    public String name;

    public String capabilities = "TilesOnly";

    public String type = "indexedVector";

    public String tileMap; // = "/tilemap";

    public String defaultStyles = "/styles";

    public String[] tiles = new String[]{"/tile/{z}/{x}/{y}.pbf"};

    public boolean exportTilesAllowed = false;

    public Extent initialExtent;

    public Extent fullExtent;

    public double minScale;

    public double maxScale;

    public TileInfo tileInfo;
}
