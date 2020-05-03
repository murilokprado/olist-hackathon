package com.hackathon.olist.question;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class QuestionFactory {
    private String reported;
    private LocalDateTime created;
    private LocalDateTime updated_at;
    private String customerName;
    private String customerId;
    private String referenceType;
    private String status;
    private String body;
    private String brandedStoreSlug;

    public Question create(String[] asks) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        Question question = new Question();
        question.setReported(asks[0]);
        question.setCreated(LocalDateTime.parse(asks[1], formatter));
        question.setUpdated(LocalDateTime.parse(asks[2], formatter));
        question.setCustomerName(new Faker().name().name());
        question.setCustomerId(new Faker().idNumber().valid());
        question.setReferenceType(asks[5]);
        question.setStatus(asks[6]);
        question.setBody(asks[7]);
        question.setBrandedStoreSlug(asks[8]);

        return question;
    }
}
