package com.example.quizapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.quizapp.model.QuizScore;
import com.example.quizapp.model.User;

public interface QuizScoreRepository extends JpaRepository<QuizScore, Integer> {
	Optional<QuizScore> findByUser(User user);
	@Query("Select  qs from QuizScore qs join Fetch qs.user order by qs.score desc")
	List<QuizScore> findAllScores();
	void deleteByUser(User user);
}
