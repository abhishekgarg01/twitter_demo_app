package com.algoworks.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMentions {

    @JsonProperty("id")
    private long userMentionId;
    @JsonProperty("id_str")
    private long userMentionIdStr;

    @JsonProperty("screen_name")
    private String userMentionScreenName;
    @JsonProperty("name")
    private String userMentionName;
    @JsonProperty("indices")
    private int[] userMentionIndices;

}
