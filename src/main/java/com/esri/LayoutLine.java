package com.esri;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LayoutLine extends LayoutBase
{
    @JsonProperty("line-join")
    public String lineJoin;

    @JsonProperty("line-cap")
    public String lineCap;
}
