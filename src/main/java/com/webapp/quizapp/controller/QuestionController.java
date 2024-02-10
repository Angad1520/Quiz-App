package com.webapp.quizapp.controller;

import com.webapp.quizapp.modal.Question;
import com.webapp.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQues")
    public ResponseEntity<List<Question>> getAllQues(){

        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuesbyCategory(@PathVariable String category){
        return questionService.getQuesbyCategory(category);
    }

    @PostMapping("addQues")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
}
