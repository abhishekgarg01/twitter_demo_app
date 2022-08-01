package com.algoworks.demo.controller;

import com.algoworks.demo.builder.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("algoworks/api")
public class TweetController {

    @Autowired
    private TweetService tweetService;

    @GetMapping("tweets")
    public ResponseEntity<Object> getAllTweets()
    {
        try{
            if(!tweetService.getAlltweets().isEmpty())
            {
                return new ResponseEntity<>(tweetService.getAlltweets(), HttpStatus.OK);
            }
            return new ResponseEntity<>("Data Not found", HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("users")
    public ResponseEntity<Object> getUsers()
    {
        try{
            if(!tweetService.getAllUsers().isEmpty())
            {
                return new ResponseEntity<>(tweetService.getAllUsers(),HttpStatus.OK);
            }
            return new ResponseEntity<>("Data Not Found",HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("tweetbyid")
    public ResponseEntity<Object> getTweetById(@RequestParam long tweetId)
    {
        try{
            if(tweetService.getTweetById(tweetId).getId() != 0)
            {
                return new ResponseEntity<>(tweetService.getTweetById(tweetId),HttpStatus.OK);
            }
            return new ResponseEntity<>("Data Not Found",HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("userbyname")
    public ResponseEntity<Object> getUserByScreenName(@RequestParam String screenName)
    {
        try{
            if(tweetService.getUserByScreenName(screenName).getScreenName() !=null)
            {
                return new ResponseEntity<>(tweetService.getUserByScreenName(screenName),HttpStatus.OK);
            }
            return new ResponseEntity<>("Data Not Found",HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
