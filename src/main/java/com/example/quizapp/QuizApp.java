package com.example.quizapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class QuizApp {

	public static void main(String[] args) {
		System.setProperty("DATABASE_HOST", System.getenv("DATABASE_HOST"));
		System.setProperty("DATABASE_PORT", System.getenv("DATABASE_PORT"));
		System.setProperty("DATABASE_NAME", System.getenv("DATABASE_NAME"));
		System.setProperty("DATABASE_USER", System.getenv("DATABASE_USER"));
		System.setProperty("DATABASE_PASSWORD", System.getenv("DATABASE_PASSWORD"));

		SpringApplication.run(QuizApp.class, args);
	}

}
