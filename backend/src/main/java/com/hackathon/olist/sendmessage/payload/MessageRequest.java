package com.hackathon.olist.sendmessage.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageRequest {

    private String message;
    private String phoneNumber;
}
