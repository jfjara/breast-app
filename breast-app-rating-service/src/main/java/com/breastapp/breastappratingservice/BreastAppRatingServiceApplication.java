package com.breastapp.breastappratingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class BreastAppRatingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BreastAppRatingServiceApplication.class, args);
	}

}
