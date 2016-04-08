package com.esri;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LOD implements Serializable
{
    public int level;
    public double resolution;
    public double scale;

    public LOD()
    {
    }

    public LOD(final int level, final double resolution, final double scale)
    {
        this.level = level;
        this.resolution = resolution;
        this.scale = scale;
    }
}
