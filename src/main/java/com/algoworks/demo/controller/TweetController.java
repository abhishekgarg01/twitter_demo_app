package com.algoworks.demo.controller;

import com.algoworks.demo.builder.TweetService;
import com.algoworks.demo.dto.TweetResponse;
import com.algoworks.demo.dto.TwitterUser;
import com.algoworks.demo.exception.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("algoworks/api")
public class TweetController {

    Logger logger = Logger.getLogger(TweetController.class.getName());
    @Autowired
    private TweetService tweetService;

    @GetMapping("/tweets")
    public List<TweetResponse> getAllTweets() {
        List<TweetResponse> responses = new ArrayList<>();
        try {
            responses = tweetService.getAllTweets();
        } catch (Exception e) {
            logger.info(e.toString());
        }
        return responses;
    }

    @GetMapping("/users")
    public List<TwitterUser> getUsers() {
        List<TwitterUser> users = new ArrayList<>();
        try {
            users = tweetService.getAllUsers();
        } catch (Exception e) {
            logger.info(e.toString());
        }
        return users;
    }

    @GetMapping("/tweet/{tweetId}")
    public TweetResponse getTweetById(@PathVariable(value = "tweetId", required = true) long tweetId) throws InvalidInputException {
        TweetResponse tweetResponse = null;
        try {
            if (tweetId <= 0) {
                throw new InvalidInputException("Tweet id must be valid");
            }
            tweetResponse = tweetService.getTweetById(tweetId);
        } catch (Exception e) {
            logger.info(e.toString());
        }
        return tweetResponse;

    }

    @GetMapping("/user/{screenName}")
    public TwitterUser getUserByScreenName(@PathVariable(value = "screenName", required = true) String screenName) throws InvalidInputException {
        TwitterUser twitterUser = null;
        try {
            if (screenName == null || screenName == "") {
                throw new InvalidInputException("Screen Name must be valid");
            }
            twitterUser = tweetService.getUserByScreenName(screenName);

        } catch (Exception e) {
            logger.info(e.toString());
        }
        return twitterUser;
    }
}
