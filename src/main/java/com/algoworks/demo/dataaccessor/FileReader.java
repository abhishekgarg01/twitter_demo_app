package com.algoworks.demo.dataaccessor;

import com.algoworks.demo.dto.Tweet;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileReader {

    @Value("${file.path}")
    private String JSON_PATH;

    public List<Tweet> fileReader() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Tweet>> typeReference = new TypeReference<List<Tweet>>() {
        };
        List<Tweet> tweets = new ArrayList<Tweet>();
        try {
            InputStream inputStream = Files.newInputStream(Paths.get(JSON_PATH));
            tweets = mapper.readValue(inputStream, typeReference);
        } catch (Exception e) {
            System.err.println("Unable to read tweets: " + e.getMessage());
        }
        return tweets;
    }
}
