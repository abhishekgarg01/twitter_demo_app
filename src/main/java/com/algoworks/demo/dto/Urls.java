package com.algoworks.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Urls {

    private String url;
    @JsonProperty("expanded_url")
    private String expandedUrl;
    @JsonProperty("display_url")
    private String displayUrl;
    private int[] indices;
}
