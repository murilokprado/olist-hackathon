package com.hackathon.olist.question.service;

import com.hackathon.olist.csv.CsvReader;
import com.hackathon.olist.question.Question;
import com.hackathon.olist.question.TypesQuestion;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuestionServiceImpl implements QuestionService {

    private static final String COLOR_REGEX = "(.*branco.*)|(.*preto.*)|(.*azul.*)|(.*cinza.*)|(.*marrom.*)|(.*amarelo.*)|(.*rosa.*)|(.*vermelho.*)|(.*verde.*)";
    private static final String CEP_REGEX = "(.*cep.*)|\\d{5}-\\d{3}|\\d{8}";
    private static final String OFFENSIVE_REGEX = "(.*péssima.*)|(.*pessima.*)|(.*péssimo.*)|(.*pessimo.*)|(.*ruim.*)";
    private static final String NOT_INFORMED_REGEX = "(.*não sei.*)|(.*nao sei.*)|(.*n sei.*)";

    private CsvReader csvReader;

    public QuestionServiceImpl(CsvReader csvReader) {
        this.csvReader = csvReader;
    }

    @Override
    public Map<TypesQuestion, List<Question>> getQuestionsByType() {
        Map<TypesQuestion, List<Question>> questionsMap = new HashMap<>();
        List<Question> questions = csvReader.readCsv();

        for (Question question : questions) {
            List<Question> questionsByType = new ArrayList<>();
            TypesQuestion typeQuestion = identifyQuestion(question);
            questionsByType.add(question);

            if (questionsMap.containsKey(typeQuestion)) {
                questionsByType = questionsMap.get(typeQuestion);
                questionsByType.add(question);

                questionsMap.put(typeQuestion, questionsByType);
            } else {
                questionsMap.put(typeQuestion, questionsByType);
            }
        }

        return questionsMap;
    }

    private TypesQuestion identifyQuestion(Question question) {
        if (question.getBody().matches(OFFENSIVE_REGEX)) {
            return TypesQuestion.OFFENSIVE;
        }

        if ((question.getBody().matches(CEP_REGEX) && !question.getBody().matches(NOT_INFORMED_REGEX))
                || question.getBody().matches(COLOR_REGEX)) {
            return TypesQuestion.AUTOMATIC_ANSWER;
        }

        return TypesQuestion.NOT_IDENTIFIED;
    }
}
