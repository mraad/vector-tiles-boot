package com.esri;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LayoutSymbol extends LayoutBase
{
    @JsonProperty("icon-rotation-alignment")
    public String iconRotationAlignment;

    @JsonProperty("icon-allow-overlap")
    public Boolean iconAllowOverlap;

    @JsonProperty("icon-image")
    public String iconImage;

    @JsonProperty("icon-padding")
    public Integer iconPadding;

    @JsonProperty("symbol-placement")
    public String symbolPlacement;

    @JsonProperty("symbol-avoid-edges")
    public Boolean symbolAvoidEdges;

    @JsonProperty("text-max-width")
    public Integer textMaxWidth;

    @JsonProperty("text-field")
    public String textField;

    @JsonProperty("text-anchor")
    public String textAnchor;

    @JsonProperty("text-size")
    public Float textSize;

    @JsonProperty("text-padding")
    public Integer textPadding;

    @JsonProperty("text-allow-overlap")
    public Boolean textAllowOverlap;

    @JsonProperty("text-letter-spacing")
    public Float textLetterSpacing;

    @JsonProperty("text-font")
    public String[] textFonts;

    @JsonProperty("text-rotation-alignment")
    public String textRotationAlignment;

    @JsonProperty("text-offset")
    public Float[] textOffsets;
}
