package com.hackathon.olist.csv;

import com.hackathon.olist.question.Question;
import com.hackathon.olist.question.QuestionFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class CsvReader {

    private QuestionFactory questionFactory;

    public CsvReader(QuestionFactory questionFactory) {
        this.questionFactory = questionFactory;
    }

    public List<Question> readCsv() {
        List<Question> questions = new ArrayList<>();

        try {
            try (Scanner scanner = new Scanner(new File("src/main/resources/sample-perguntas.csv"))) {

                scanner.nextLine();

                while (scanner.hasNext()) {
                    String[] line = scanner.nextLine().split(",");

                    questions.add(questionFactory.create(line));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return questions;
    }
}
