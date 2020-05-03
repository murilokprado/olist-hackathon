package com.hackathon.olist.csv;

import com.hackathon.olist.question.Question;
import com.hackathon.olist.question.QuestionFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CsvReader {

    private QuestionFactory questionFactory;

    public CsvReader(QuestionFactory questionFactory) {
        this.questionFactory = questionFactory;
    }

    public List<Question> readCsv() {
        List<Question> questions = new ArrayList<>();

        try (InputStream inputStream = getClass().getResourceAsStream("/sample-perguntas.csv");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            List<String> contents = reader.lines().collect(Collectors.toList());

            contents.remove(0);

            for (String content : contents) {
                String[] line = content.split(",");

                questions.add(questionFactory.create(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return questions;
    }
}
