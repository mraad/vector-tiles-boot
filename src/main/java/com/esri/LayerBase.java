package com.esri;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LayerBase implements ILayer
{
    @JsonProperty("id")
    public String id;

    @JsonProperty("type")
    public String type;

    @JsonProperty("paint")
    public IPaint paint;

    public LayerBase()
    {
    }

    public LayerBase(final String id, final String type, final IPaint paint)
    {
        this.id = id;
        this.type = type;
        this.paint = paint;
    }
}
