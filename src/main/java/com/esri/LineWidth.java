package com.esri;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LineWidth implements Serializable
{
    @JsonProperty("line-color")
    public String lineColor;

    @JsonProperty("base")
    public Float base;

    @JsonProperty("stops")
    public Float[][] stops;

    @JsonProperty("line-dasharray")
    public Float[] lineDasharray;

    @JsonProperty("line-translate")
    public Float[] lineTranslate;
}
