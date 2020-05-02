package com.hackathon.olist.bot.service;

import com.hackathon.olist.bot.payload.MessageResponse;
import com.hackathon.olist.sendmessage.payload.MessageRequest;
import com.twilio.rest.chat.v2.service.channel.Message;

import java.util.List;

public interface AutopilotBotService {

    List<MessageResponse> getMessages();

    Message createMessage(MessageRequest messageRequest);
}
