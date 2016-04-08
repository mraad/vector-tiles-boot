package com.esri;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SpatialReference
{
    public String cs;

    public Integer wkid;

    public Integer latestWkid;

    public SpatialReference()
    {
    }

    public SpatialReference(final String cs, final Integer wkid, final Integer latestWkid)
    {
        this.cs = cs;
        this.wkid = wkid;
        this.latestWkid = latestWkid;
    }

    public SpatialReference(final String cs, final Integer wkid)
    {
        this.cs = cs;
        this.wkid = wkid;
    }

    public SpatialReference(final Integer wkid, final Integer latestWkid)
    {
        this.wkid = wkid;
        this.latestWkid = latestWkid;
    }
}
