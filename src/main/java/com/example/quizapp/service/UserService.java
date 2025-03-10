package com.example.quizapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.quizapp.model.QuizScore;
import com.example.quizapp.model.QuizScoreDto;
import com.example.quizapp.model.User;
import com.example.quizapp.repository.QuizScoreRepository;
import com.example.quizapp.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private QuizScoreRepository quizScoreRepository;
	
	public User getOrCreateUser(String username) {
		return userRepository.findByUsername(username)
				.orElseGet(()-> userRepository.save(new User(username)));
	}
	
	@Transactional
	public QuizScore addQuizScore(String username,int score) {
		User user = getOrCreateUser(username);
		QuizScore existingScore = quizScoreRepository.findByUser(user).stream().findFirst().orElse(null);
		if(existingScore != null) {
			existingScore.setScore(score);
			existingScore.setQuizDate(LocalDate.now());
			return quizScoreRepository.save(existingScore);
		} else {
			QuizScore quizScore = new QuizScore();
			quizScore.setScore(score);
			quizScore.setQuizDate(LocalDate.now());
			quizScore.setUser(user);
			return quizScoreRepository.save(quizScore);
		}
		
	}	
	
	public Page<QuizScore> getAllScores(int page, int size){
		//return quizScoreRepository.findAll(pageable);
		Pageable pageable = PageRequest.of(page, size);
		List<QuizScore> scores = quizScoreRepository.findAllScores();
		
		int start =Math.min((int) pageable.getOffset(),scores.size());
		int end = Math.min((start + pageable.getPageSize()),scores.size());
		List<QuizScore> pagintatedScores = scores.subList(start, end);
		
		return new PageImpl<>(pagintatedScores,pageable,scores.size());
	}
}
