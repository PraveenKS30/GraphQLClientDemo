package com.example.GraphQLClientDemo.Service;

import com.example.GraphQLClientDemo.Model.GraphQLQuery;
import com.example.GraphQLClientDemo.Response.CountryResponse;
import graphql.kickstart.spring.webclient.boot.GraphQLRequest;
import graphql.kickstart.spring.webclient.boot.GraphQLResponse;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class GraphQLRespPayLoad {

    @Autowired
    private GraphQLWebClient graphQLWebClient;

    public void getGraphQLRespPayLoad(){
        String queryStr = "query($code: ID!) {\n" +
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

        Map<String, Object> variables = new HashMap<>();
        variables.put("code", "IN");

        GraphQLRequest request = GraphQLRequest.builder()
                        .query(queryStr).variables(variables).build();

        System.out.println(request.toString());

        GraphQLResponse response = graphQLWebClient.post(request).block();
        System.out.println(response);

        System.out.println(response.get("country", CountryResponse.class));

        System.out.println(response.get("country", CountryResponse.class).getCapital());
        System.out.println(response.get("country", CountryResponse.class).getCurrency());

    }
}
