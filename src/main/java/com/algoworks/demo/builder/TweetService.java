package com.algoworks.demo.builder;

import com.algoworks.demo.dataaccessor.FileReader;
import com.algoworks.demo.dto.Tweet;
import com.algoworks.demo.dto.TweetResponse;
import com.algoworks.demo.dto.TwitterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
