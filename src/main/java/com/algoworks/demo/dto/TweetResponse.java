package com.algoworks.demo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TweetResponse {

    private String dateOfCreation;
    private long id;
    private String text;
}
