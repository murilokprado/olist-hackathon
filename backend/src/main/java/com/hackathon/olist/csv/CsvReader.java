package com.hackathon.olist.csv;

import com.hackathon.olist.ask.Ask;
import com.hackathon.olist.ask.AskFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class CsvReader {

    private AskFactory askFactory;

    public CsvReader(AskFactory askFactory) {
        this.askFactory = askFactory;
    }

    public List<Ask> readCsv() {
        List<Ask> asks = new ArrayList<>();

        try {
            try (Scanner scanner = new Scanner(new File("src/main/resources/sample-perguntas.csv"))) {

                scanner.nextLine();

                while (scanner.hasNext()) {
                    String[] line = scanner.nextLine().split(",");

                    asks.add(askFactory.create(line));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return asks;
    }
}
