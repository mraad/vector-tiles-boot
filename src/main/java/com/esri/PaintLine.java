package com.esri;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * https://www.mapbox.com/mapbox-gl-style-spec/#layers-line
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaintLine implements IPaint
{
    @JsonProperty("line-color")
    public String lineColor;

    @JsonProperty("line-width")
    public LineWidth lineWidth;

    public PaintLine()
    {
    }

    public PaintLine(final String lineColor)
    {
        this.lineColor = lineColor;
    }

    public PaintLine(final String lineColor, final LineWidth lineWidth)
    {
        this.lineColor = lineColor;
        this.lineWidth = lineWidth;
    }
}
