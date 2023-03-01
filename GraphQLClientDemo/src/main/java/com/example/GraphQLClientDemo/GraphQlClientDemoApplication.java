package com.example.GraphQLClientDemo;

import com.example.GraphQLClientDemo.Service.GetRespPayLoad;
import com.example.GraphQLClientDemo.Service.GraphQLRespPayLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphQlClientDemoApplication implements CommandLineRunner {

	@Autowired
	GetRespPayLoad getRespPayLoad;

	@Autowired
	GraphQLRespPayLoad graphQLRespPayLoad;

	public static void main(String[] args) {
		SpringApplication.run(GraphQlClientDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//call with restTemplate
		//getRespPayLoad.getPayload();

		//call with graphql webclient
		graphQLRespPayLoad.getGraphQLRespPayLoad();


	}
}
