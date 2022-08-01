package com.algoworks.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Place {

    private String id;
    private String url;
    @JsonProperty("place_type")
    private String placeType;
    private String name;
    @JsonProperty("full_name")
    private String fullName;
    @JsonProperty("country_code")
    private String countryCode;
    private String country;
    @JsonProperty("polylines")
    private String[] polyLines;
    @JsonProperty("bounding_box")
    private Map<String,Object> boundingBox;
    @JsonProperty("attributes")
    private Object attribute;

}
