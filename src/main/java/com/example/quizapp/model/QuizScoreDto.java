package com.example.quizapp.model;

import java.time.LocalDate;

public class QuizScoreDto {
	private int id;
	private int score;
	private LocalDate date;
	private String username;
	
	public QuizScoreDto(  String username,int score,LocalDate date) {
		this.score = score;
		this.date = date;
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
