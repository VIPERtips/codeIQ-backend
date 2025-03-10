package com.example.quizapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class QuizApp {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		System.setProperty("DATABASE_HOST", dotenv.get("DATABASE_HOST"));
        System.setProperty("DATABASE_PORT", dotenv.get("DATABASE_PORT"));
        System.setProperty("DATABASE_NAME", dotenv.get("DATABASE_NAME"));
        System.setProperty("DATABASE_USER", dotenv.get("DATABASE_USER"));
        System.setProperty("DATABASE_PASSWORD", dotenv.get("DATABASE_PASSWORD"));
		
		SpringApplication.run(QuizApp.class, args);
	}

}
