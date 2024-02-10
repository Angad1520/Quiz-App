package com.webapp.quizapp.modal;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "question_table")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String category;
    private String ques_title;
    private String diff_lvl;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String right_ans;
}
