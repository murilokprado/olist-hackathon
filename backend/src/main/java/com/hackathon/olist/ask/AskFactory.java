package com.hackathon.olist.ask;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class AskFactory {
    private String reported;
    private LocalDateTime created;
    private LocalDateTime updated_at;
    private String customerName;
    private String customerId;
    private String referenceType;
    private String status;
    private String body;
    private String brandedStoreSlug;

    public Ask create(String[] asks) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        Ask ask = new Ask();
        ask.setReported(asks[0]);
        ask.setCreated(LocalDateTime.parse(asks[1], formatter));
        ask.setUpdated(LocalDateTime.parse(asks[2], formatter));
        ask.setCustomerName(new Faker().name().name());
        ask.setCustomerId(new Faker().idNumber().valid());
        ask.setReferenceType(asks[5]);
        ask.setStatus(asks[6]);
        ask.setBody(asks[7]);
        ask.setBrandedStoreSlug(asks[8]);

        return ask;
    }
}
