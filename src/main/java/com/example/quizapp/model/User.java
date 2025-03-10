package com.example.quizapp.model;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;


@Entity

public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true)
	private String username;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true )
	@JsonBackReference
	private List<QuizScore> quizScores = new ArrayList<>();
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String username) {
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<QuizScore> getQuizScores() {
		return quizScores;
	}
	public void setQuizScores(List<QuizScore> quizScores) {
		this.quizScores = quizScores;
	}
	
}
