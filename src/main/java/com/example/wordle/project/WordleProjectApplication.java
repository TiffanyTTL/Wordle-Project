package com.example.wordle.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class WordleProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(WordleProjectApplication.class, args);
	}

}
