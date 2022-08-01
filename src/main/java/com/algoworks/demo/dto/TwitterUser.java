package com.algoworks.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TwitterUser {

    private long id;
    @JsonProperty("id_str")
    private long idStr;
    private String name;
    @JsonProperty("screen_name")
    private String screenName;
    private String location;
    private String description;
    @JsonProperty("url")
    private String userUrl;

    private UserEntities entities;

    @JsonProperty("protected")
    private boolean isProtected;
    @JsonProperty("followers_count")
    private int followersCount;
    @JsonProperty("friends_count")
    private int friendsCount;
    @JsonProperty("listed_count")
    private int listedCount;
    @JsonProperty("created_at")
    private String userCreatedAt;
    @JsonProperty("favourites_count")
    private int favouritesCount;
    @JsonProperty("utc_offset")
    private int utcOffset;
    @JsonProperty("time_zone")
    private String timeZone;
    @JsonProperty("geo_enabled")
    private boolean isGeoEnabled;
    private boolean isVerified;
    @JsonProperty("statuses_count")
    private int statusCount;
    @JsonProperty("lang")
    private String userLang;
    @JsonProperty("contributors_enabled")
    private boolean isContributorsEnabled;
    @JsonProperty("is_translator")
    private boolean isTranslated;
    @JsonProperty("profile_background_color")
    private String profileBackgroundColor;
    @JsonProperty("profile_background_image_url")
    private String profileBackgroundImageUrl;
    @JsonProperty("profile_background_image_url_https")
    private String profileBackgroundImageUrlHttps;
    @JsonProperty("profile_background_tile")
    private boolean profileBackgroundTitle;
    @JsonProperty("profile_image_url")
    private String profileImageUrl;
    @JsonProperty("profile_image_url_https")
    private String profileImageUrlHttps;
    @JsonProperty("profile_banner_url")
    private String profileBannerUrl;
    @JsonProperty("profile_link_color")
    private String profileLinkColor;
    @JsonProperty("profile_sidebar_border_color")
    private String profileSidebarBorderColor;
    @JsonProperty("profile_sidebar_fill_color")
    private String profileSidebarFillColor;
    @JsonProperty("profile_text_color")
    private String profileTextColor;
    @JsonProperty("profile_use_background_image")
    private boolean profileUseBackgroundImage;
    @JsonProperty("default_profile")
    private boolean defaultProfile;
    @JsonProperty("default_profile_image")
    private boolean defaultProfileImage;
    private String following;
    @JsonProperty("follow_request_sent")
    private boolean followRequestSent;
    private String notifications;
}
