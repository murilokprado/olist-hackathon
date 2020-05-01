package com.hackathon.olist.bot.service;

import com.hackathon.olist.bot.payload.MessageResponse;
import com.hackathon.olist.sendmessage.payload.MessageRequest;
import com.twilio.rest.chat.v2.service.Channel;
import com.twilio.rest.chat.v2.service.channel.Message;
import com.twilio.rest.chat.v2.service.channel.Webhook;
import com.twilio.rest.chat.v2.service.user.UserChannel;

import java.util.List;

public interface AutopilotBotService {

    Webhook createWebhook();

    Channel createChannel();

    UserChannel getUser();

    List<MessageResponse> getMessages();

    Message createMessage(MessageRequest messageRequest);
}
