package com.hackathon.olist.question.service;

import com.hackathon.olist.question.Question;
import com.hackathon.olist.question.TypesQuestion;

import java.util.List;
import java.util.Map;

public interface QuestionService {

    Map<TypesQuestion, List<Question>> getQuestionsByType();
}
