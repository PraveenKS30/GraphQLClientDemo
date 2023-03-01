package com.example.GraphQLClientDemo.Response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Data
@Getter
@Setter
public class CountryResponse {

    private String name;
    private String capital;
    private String emoji;
    private String currency;

}
