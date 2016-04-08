package com.esri;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * https://www.mapbox.com/mapbox-gl-style-spec/#layers-symbol
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaintSymbol implements IPaint
{
    @JsonProperty("text-color")
    public String textColor;

    @JsonProperty("text-halo-width")
    public Float textHaloWidth;

    @JsonProperty("text-halo-color")
    public String textHaloColor;
}
