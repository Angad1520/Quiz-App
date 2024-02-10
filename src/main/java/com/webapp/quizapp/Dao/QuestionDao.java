package com.webapp.quizapp.Dao;

import com.webapp.quizapp.modal.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

    List<Question> findQuestionByCategory(String Category);

    @Query(value= "SELECT * FROM question_table WHERE category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> findrandomQues(String category, Integer numQ);
}
