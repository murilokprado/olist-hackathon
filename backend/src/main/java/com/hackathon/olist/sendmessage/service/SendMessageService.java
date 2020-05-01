package com.hackathon.olist.sendmessage.service;

import com.hackathon.olist.sendmessage.payload.MessageRequest;
import com.twilio.rest.api.v2010.account.Message;

public interface SendMessageService {

    Message sendSms(MessageRequest messageRequest);

    Message sendWhatsapp(MessageRequest messageRequest);
}
