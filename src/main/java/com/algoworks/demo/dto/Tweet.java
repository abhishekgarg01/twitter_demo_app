package com.algoworks.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tweet {
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("id")
    private long userId;
    @JsonProperty("id_str")
    private long userIdStr;
    private String text;
    private String source;
    @JsonProperty("truncated")
    private boolean isTruncated;
    @JsonProperty("in_reply_to_status_id")
    private String inReplyToStatusId;
    @JsonProperty("in_reply_to_status_id_str")
    private String inReplyToStatusIdStr;
    @JsonProperty("in_reply_to_user_id")
    private String inReplyToUserId;
    @JsonProperty("in_reply_to_user_id_str")
    private String inReplyToUserIdStr;
    @JsonProperty("in_reply_to_screen_name")
    private String inReplyToScreenName;

    private TwitterUser user;

    private Geo geo;

    private Coordinates coordinates;

    private Place place;

    private String contributors;
    @JsonProperty("retweet_count")
    private String retweetCount;

    @JsonProperty("entities")
    private TweetEntities tweetEntities;
    @JsonProperty("favorited")
    private boolean isFavorite;
    @JsonProperty("retweeted")
    private boolean isRetweeted;
    @JsonProperty("possibly_sensitive")
    private boolean isSensitive;
    private String lang;

}
