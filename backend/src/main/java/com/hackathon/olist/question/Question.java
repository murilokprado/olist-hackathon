package com.hackathon.olist.question;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Question {

    private String reported;
    private LocalDateTime created;
    private LocalDateTime updated;
    private String customerName;
    private String customerId;
    private String referenceType;
    private String status;
    private String body;
    private String brandedStoreSlug;
}
