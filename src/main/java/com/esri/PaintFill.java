package com.esri;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * https://www.mapbox.com/mapbox-gl-style-spec/#layers-fill
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaintFill implements IPaint
{
    @JsonProperty("fill-color")
    public String fillColor = "#ff0000";

    @JsonProperty("fill-opacity")
    public Float fillOpacity;

    @JsonProperty("fill-outline-color")
    public String fillOutlineColor;

    @JsonProperty("fill-pattern")
    public String fillPattern;

    public PaintFill()
    {
    }

    public PaintFill(final String fillColor, final Float fillOpacity, final String fillOutlineColor)
    {
        this.fillColor = fillColor;
        this.fillOpacity = fillOpacity;
        this.fillOutlineColor = fillOutlineColor;
    }
}
