package com.hackathon.olist.bot.service;

import com.hackathon.olist.bot.AutopilotBotFactory;
import com.hackathon.olist.bot.payload.MessageResponse;
import com.hackathon.olist.sendmessage.payload.MessageRequest;
import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.chat.v2.service.Channel;
import com.twilio.rest.chat.v2.service.channel.Message;
import com.twilio.rest.chat.v2.service.channel.Webhook;
import com.twilio.rest.chat.v2.service.user.UserChannel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AutopilotBotServiceImpl implements AutopilotBotService {

    @Value("${twilio.id}")
    private String twilioId;

    @Value("${twilio.token}")
    private String twilioToken;

    @Value("${twilio.service.id}")
    private String twilioServiceId;

    private AutopilotBotFactory autopilotBotFactory;

    public AutopilotBotServiceImpl(AutopilotBotFactory autopilotBotFactory) {
        this.autopilotBotFactory = autopilotBotFactory;
    }

    @Override
    public Webhook createWebhook() {
        Twilio.init(twilioId, twilioToken);

        return Webhook.creator(
                twilioServiceId,
                "CH67d6f35bf09d4c2ea6bef0d91ee87b18",
                Webhook.Type.WEBHOOK)
                .setConfigurationFilters(Arrays.asList("onMessageSent"))
                .setConfigurationMethod(Webhook.Method.POST)
                .setConfigurationUrl("https://channels.autopilot.twilio.com/v1/AC4e3c39e8b433f7689a6a0d378b36745a/UAc07612a9ed06c9aeac40e285b49720fc/twilio-messaging")
                .create();
    }

    @Override
    public Channel createChannel() {
        Twilio.init(twilioId, twilioToken);

        UserChannel user = getUser();

        return Channel.creator(user.getServiceSid())
                .create();
    }

    @Override
    public UserChannel getUser() {
        Twilio.init(twilioId, twilioToken);

        return UserChannel.fetcher(
                twilioServiceId,
                "US23752a10903e4007a5747685d64b167b",
                "CH67d6f35bf09d4c2ea6bef0d91ee87b18")
                .fetch();
    }

    @Override
    public List<MessageResponse> getMessages() {
        Twilio.init(twilioId, twilioToken);

        ResourceSet<Message> resourceMessages = Message.reader(twilioServiceId, "CH67d6f35bf09d4c2ea6bef0d91ee87b18")
                .limit(20)
                .read();

        return autopilotBotFactory.create(resourceMessages);
    }

    @Override
    public Message createMessage(MessageRequest messageRequest) {
        Twilio.init(twilioId, twilioToken);

        return Message
                .creator(twilioServiceId, "CH67d6f35bf09d4c2ea6bef0d91ee87b18")
                .setBody(messageRequest.getMessage())
                .create();
    }
}
