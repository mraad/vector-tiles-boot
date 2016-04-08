package com.esri;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Extent
{
    public double xmin;
    public double ymin;
    public double xmax;
    public double ymax;
    public SpatialReference spatialReference;

    public Extent()
    {
    }

    public Extent(final double xmin, final double ymin, final double xmax, final double ymax, final SpatialReference spatialReference)
    {
        this.xmin = xmin;
        this.ymin = ymin;
        this.xmax = xmax;
        this.ymax = ymax;
        this.spatialReference = spatialReference;
    }
}
