package com.algoworks.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntitiesUrl {

    private List<UserEntitiesUrls> urls;

}
