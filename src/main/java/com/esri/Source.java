package com.esri;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Source implements Serializable
{
    @JsonProperty("type")
    public String type = "vector";

    @JsonProperty("url")
    public String url;

    public Source()
    {
    }

    public Source(final String url)
    {
        this.url = url;
    }

    public Source(final String type, final String url)
    {
        this.type = type;
        this.url = url;
    }

}
