package com.example.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.quizapp.model.QuizScore;
import com.example.quizapp.model.ScoreRequest;
import com.example.quizapp.model.User;
import com.example.quizapp.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
	 @Autowired
	 private UserService userService;
	 
	 @GetMapping
	 public User getUser(@RequestParam String username) {
		 return userService.getOrCreateUser(username);
	 }
	 
	 @PostMapping("/score")
	 public QuizScore addScore(@RequestBody ScoreRequest req) {
		 return userService.addQuizScore(req.getUsername(), req.getScore());
	 }
	 
	 @GetMapping("/all-scores")
	 public Page<QuizScore> getScores(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
		 return userService.getAllScores(
				 page,size
				 );
	 }
}
