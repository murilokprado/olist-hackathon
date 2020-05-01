package com.hackathon.olist.bot;

import com.hackathon.olist.bot.payload.MessageResponse;
import com.twilio.base.ResourceSet;
import com.twilio.rest.chat.v2.service.channel.Message;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AutopilotBotFactory {

    public MessageResponse create(Message message) {
        MessageResponse messageResponse = new MessageResponse();

        messageResponse.setId(message.getSid());
        messageResponse.setBody(message.getBody());
        messageResponse.setDateCreated(message.getDateCreated());
        messageResponse.setFrom(message.getFrom());

        return messageResponse;
    }

    public List<MessageResponse> create(ResourceSet<Message> messages) {
        List<MessageResponse> messageResponses = new ArrayList<>();

        for (Message message : messages) {
            messageResponses.add(create(message));
        }

        return messageResponses;
    }
}
