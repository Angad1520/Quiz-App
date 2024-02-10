package com.webapp.quizapp.service;

import com.webapp.quizapp.Dao.QuestionDao;
import com.webapp.quizapp.Dao.QuizDao;
import com.webapp.quizapp.modal.Question;
import com.webapp.quizapp.modal.QuestionWrapper;
import com.webapp.quizapp.modal.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<String> createQuiz(String category, Integer numQ, String title) {

        List<Question> questions = questionDao.findrandomQues(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestion(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {

//        System.out.println("id--"+id);
        Optional<Quiz> quiz = quizDao.findById(id);

        List<Question> quesfromDB = quiz.get().getQuestion();
//        System.out.println(quesfromDB);

        List<QuestionWrapper> quesforUser = new ArrayList<>();
        for(Question q : quesfromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQues_title(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            quesforUser.add(qw);
        }

        return new ResponseEntity<>(quesforUser, HttpStatus.OK);
    }
}
