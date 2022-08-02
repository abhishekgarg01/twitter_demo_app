package com.algoworks.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TweetResponse {

    private String dateOfCreation;
    private long id;
    private String text;
}
