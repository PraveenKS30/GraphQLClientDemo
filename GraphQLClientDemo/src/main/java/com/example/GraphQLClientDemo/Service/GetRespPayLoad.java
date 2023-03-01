package com.example.GraphQLClientDemo.Service;

import com.example.GraphQLClientDemo.Model.GraphQLQuery;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class GetRespPayLoad {

    private final String url = "https://countries.trevorblades.com/graphql";

    public void getPayload(){

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String query = "query($code: ID!) {\n" +
                "  country(code: $code) {\n" +
                "    name\n" +
                "    native\n" +
                "    capital\n" +
                "    emoji\n" +
                "    currency\n" +
                "    languages {\n" +
                "      code\n" +
                "      name\n" +
                "    }\n" +
                "  }\n" +
                "}";

        //GraphQLQuery graphQuery = new GraphQLQuery();
        //graphQuery.setQuery(query);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("query", query);

        Map<String, Object> variables = new HashMap<>();
        variables.put("code", "IN");

        requestBody.put("variables",variables);

        HttpEntity<Object> entity = new HttpEntity<>(requestBody, headers);
        System.out.println(entity);

        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        System.out.println(response);
    }
}
