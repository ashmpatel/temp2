package com.example.testingwebapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TestingWebApplication {
	private static final Logger log = LoggerFactory.getLogger(TestingWebApplication.class);


	public static void main(String[] args) {
		log.info("Starting Web app");
		SpringApplication.run(TestingWebApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}


}
