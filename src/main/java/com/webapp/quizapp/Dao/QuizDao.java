package com.webapp.quizapp.Dao;


import com.webapp.quizapp.modal.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz, Integer> {
}
