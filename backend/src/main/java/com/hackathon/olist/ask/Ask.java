package com.hackathon.olist.ask;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Ask {

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
