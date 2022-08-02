package com.algoworks.demo.builder;

import com.algoworks.demo.dataaccessor.FileReader;
import com.algoworks.demo.dto.Links;
import com.algoworks.demo.dto.Tweet;
import com.algoworks.demo.dto.TweetResponse;
import com.algoworks.demo.dto.TwitterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TweetService {

    @Autowired
    FileReader fileReader;

    public List<TweetResponse> getAllTweets() {
        List<TweetResponse> tweetResponses = new ArrayList<>();
        List<Tweet> getTweets = fileReader.fileReader();
        for (Tweet t : getTweets) {
            TweetResponse tweetResponse = new TweetResponse();
            tweetResponse.setDateOfCreation(t.getCreatedAt());
            tweetResponse.setId(t.getUserId());
            tweetResponse.setText(t.getText());
            tweetResponses.add(tweetResponse);
        }
        return tweetResponses;
    }

    public List<TwitterUser> getAllUsers() {
        List<TwitterUser> users = new ArrayList<TwitterUser>();
        List<Tweet> getTweets = fileReader.fileReader();
        for (Tweet t : getTweets) {
            users.add(t.getUser());
        }
        return users;
    }

    public TweetResponse getTweetById(long tweetId) {
        TweetResponse tweetResponse = new TweetResponse();
        List<Tweet> getTweets = fileReader.fileReader();
        for (Tweet t : getTweets) {
            if (t.getUserId() == tweetId) {
                tweetResponse.setDateOfCreation(t.getCreatedAt());
                tweetResponse.setId(t.getUserId());
                tweetResponse.setText(t.getText());
                break;
            }
        }
        return tweetResponse;
    }

    public TwitterUser getUserByScreenName(String userScreenName) {
        TwitterUser user = new TwitterUser();
        List<Tweet> getTweets = fileReader.fileReader();
        for (Tweet t : getTweets) {
            if (userScreenName.equals(t.getUser().getScreenName())) {
                user = t.getUser();
                break;
            }
        }
        return user;
    }

    public Map<Long, Links> getAllUrls() {
        List<Tweet> getTweets = fileReader.fileReader();
        Map<Long, Links> externalUrls = new HashMap<>();
        Links links = null;

        for (Tweet t : getTweets) {
            links = new Links(t.getUser().getProfileBackgroundImageUrl(),
                    t.getUser().getProfileBackgroundImageUrlHttps(),
                    t.getUser().getProfileBannerUrl(), t.getUser().getProfileImageUrl(),
                    t.getUser().getProfileImageUrlHttps(), t.getUser().getUserUrl(),
                    t.getUser().getEntities().getUrl().getUrls().get(0).getUserEntityUrl(),
                    t.getUser().getEntities().getUrl().getUrls().get(0).getUserEntityExpandedUrl(),
                    t.getUser().getEntities().getUrl().getUrls().get(0).getUserEntityDisplayUrl());
            externalUrls.put(t.getUser().getId(), links);
        }

        return externalUrls;
    }
}
