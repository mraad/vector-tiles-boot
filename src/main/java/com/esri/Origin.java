package com.esri;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Origin
{
    public double x;
    public double y;

    public Origin()
    {
    }

    public Origin(final double x, final double y)
    {
        this.x = x;
        this.y = y;
    }
}
