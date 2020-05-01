package com.hackathon.olist.sendmessage.service;

import com.hackathon.olist.sendmessage.payload.MessageRequest;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SendMessageServiceImpl implements SendMessageService {

    @Value("${twilio.id}")
    private String twilioId;

    @Value("${twilio.token}")
    private String twilioToken;

    @Value("${twilio.phone-number}")
    private String twilioPhoneNumber;

    @Value("${twilio.whatsapp-number}")
    private String twilioWhatsappNumber;

    @Override
    public Message sendSms(MessageRequest messageRequest) {
        Twilio.init(twilioId, twilioToken);

        return Message.creator(
                new PhoneNumber(messageRequest.getPhoneNumber()),
                new PhoneNumber(twilioPhoneNumber),
                messageRequest.getMessage())
                .create();
    }

    @Override
    public Message sendWhatsapp(MessageRequest messageRequest) {
        Twilio.init(twilioId, twilioToken);

        return Message.creator(
                new PhoneNumber(String.format("whatsapp:%s", messageRequest.getPhoneNumber())),
                new PhoneNumber(String.format("whatsapp:%s", twilioWhatsappNumber)),
                messageRequest.getMessage())
                .create();
    }
}
