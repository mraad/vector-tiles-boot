package com.esri;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LayoutBase implements ILayout
{
    @JsonProperty("visibility")
    public String visibility;
}
