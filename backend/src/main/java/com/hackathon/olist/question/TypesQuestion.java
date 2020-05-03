package com.hackathon.olist.question;

public enum TypesQuestion {

    AUTOMATIC_ANSWER("automatic_answer"),
    OFFENSIVE("offensive"),
    NOT_IDENTIFIED("not_identified");

    private String description;

    TypesQuestion(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
