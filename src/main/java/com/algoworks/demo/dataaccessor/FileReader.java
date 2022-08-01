package com.algoworks.demo.dataaccessor;

import com.algoworks.demo.dto.Tweet;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileReader {

    private static final String JSON_PATH = "C:/Users/Abhishek Garg/IdeaProjects/twitterdemo/src/main/resources/favs.json";

    public List<Tweet> fileReader() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Tweet>> typeReference = new TypeReference<List<Tweet>>() {
        };
        List<Tweet> tweets = new ArrayList<Tweet>();
        try {
            InputStream inputStream = Files.newInputStream(Paths.get(JSON_PATH));
            tweets = mapper.readValue(inputStream, typeReference);
        } catch (Exception e) {
            System.err.println("Unable to save tweets" + e.getMessage());
        }
        return tweets;
    }
}
