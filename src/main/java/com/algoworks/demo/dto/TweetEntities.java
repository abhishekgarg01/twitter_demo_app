package com.algoworks.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TweetEntities {

    private List<Hashtag> hashtags;

    @JsonProperty("urls")
    private List<Urls> url;

    @JsonProperty("user_mentions")
    private  List<UserMentions> userMentions;

    @JsonIgnore
    private String media;

}
