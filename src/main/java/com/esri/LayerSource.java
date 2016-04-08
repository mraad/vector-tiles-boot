package com.esri;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LayerSource extends LayerBase
{
    @JsonProperty("source")
    public String source;

    @JsonProperty("source-layer")
    public String sourceLayer;

    @JsonProperty("minzoom")
    public Integer minZoom;

    @JsonProperty("maxzoom")
    public Integer maxZoom;

    @JsonProperty("filter")
    public Object[] filter;

    @JsonProperty("layout")
    public ILayout layout = new LayoutBase();

    public LayerSource()
    {
    }

    public LayerSource(final String source, final String sourceLayer, final String type, final IPaint paint)
    {
        super(sourceLayer, type, paint);
        this.source = source;
        this.sourceLayer = sourceLayer;
    }
}
