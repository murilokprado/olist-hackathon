package com.hackathon.olist.bot.payload;

import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

@Getter
@Setter
public class MessageResponse {

    private String id;
    private String body;
    private DateTime dateCreated;
    private String from;
}
