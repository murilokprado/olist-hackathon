package com.hackathon.olist.ask;

import com.hackathon.olist.csv.CsvReader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ask")
public class AskController {

    private CsvReader csvReader;

    public AskController(CsvReader csvReader) {
        this.csvReader = csvReader;
    }

    @GetMapping
    private List<Ask> readCsv() {
        return csvReader.readCsv();
    }
}
