package com.esri;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaintBackground implements IPaint
{
    @JsonProperty("background-color")
    public String backgroundColor;

    public PaintBackground()
    {
    }

    public PaintBackground(final String backgroundColor)
    {
        this.backgroundColor = backgroundColor;
    }
}
