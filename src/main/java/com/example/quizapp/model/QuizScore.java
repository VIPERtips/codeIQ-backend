package com.example.quizapp.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class QuizScore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int score;
	private LocalDate quizDate;
	private String language;
	
	@ManyToOne(fetch =  FetchType.LAZY)
	@JoinColumn(name="user_id")
	
	private User user;
	
	public QuizScore() {
		// TODO Auto-generated constructor stub
	}

	public QuizScore(int score, User user) {
		this.score = score;
		this.user = user;
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

	public LocalDate getQuizDate() {
		return quizDate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setQuizDate(LocalDate quizDate) {
		this.quizDate = quizDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
}
