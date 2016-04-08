package com.esri;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Map;

/**
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Styles implements Serializable
{
    @JsonProperty("version")
    public int version = 8;

    @JsonProperty("sprite")
    public String sprite = "/sprite";

    @JsonProperty("glyphs")
    public String glyphs = "/fonts/{fontstack}/{range}.pbf";

    @JsonProperty("sources")
    public Map<String, Source> sources;

    @JsonProperty("layers")
    public ILayer[] layers;
}
