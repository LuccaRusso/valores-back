package com.example.CardGame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class CardGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardGameApplication.class, args);
	}

}
