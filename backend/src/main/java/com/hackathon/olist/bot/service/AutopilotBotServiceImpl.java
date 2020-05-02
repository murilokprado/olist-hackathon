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

    @Value("${twilio.channel.id}")
    private String twilioChannelId;

    @Value("${twilio.channel.url}")
    private String twilioChannelUrl;

    private AutopilotBotFactory autopilotBotFactory;

    public AutopilotBotServiceImpl(AutopilotBotFactory autopilotBotFactory) {
        this.autopilotBotFactory = autopilotBotFactory;
    }

    @Override
    public Webhook createWebhook() {
        Twilio.init(twilioId, twilioToken);

        ResourceSet<Webhook> webhooks = Webhook.reader(twilioServiceId, twilioChannelId).read();

        for(Webhook webhook: webhooks) {
            Webhook.deleter(twilioServiceId, twilioChannelId, webhook.getSid()).delete();
        }

        return Webhook.creator(
                twilioServiceId,
                twilioChannelId,
                Webhook.Type.WEBHOOK)
                .setConfigurationFilters(Arrays.asList("onMessageSent"))
                .setConfigurationMethod(Webhook.Method.POST)
                .setConfigurationUrl(twilioChannelUrl)
                .create();
    }

    @Override
    public Channel createChannel() {
        Twilio.init(twilioId, twilioToken);

        return Channel.creator(twilioServiceId)
                .create();
    }

    @Override
    public List<MessageResponse> getMessages() {
        Twilio.init(twilioId, twilioToken);

        ResourceSet<Message> resourceMessages = Message.reader(twilioServiceId, twilioChannelId)
                .limit(100)
                .read();

        return autopilotBotFactory.create(resourceMessages);
    }

    @Override
    public Message createMessage(MessageRequest messageRequest) {
        createWebhook();
        Twilio.init(twilioId, twilioToken);

        return Message
                .creator(twilioServiceId, twilioChannelId)
                .setBody(messageRequest.getMessage())
                .setFrom("user")
                .create();
    }

    private UserChannel getUser() {
        return UserChannel.fetcher(
                twilioServiceId,
                "US23752a10903e4007a5747685d64b167b",
                twilioChannelId)
                .fetch();
    }

    private void deleteMessages(ResourceSet<Message> resourceMessages) {
        for (Message message : resourceMessages) {
            Message.deleter(twilioServiceId, twilioChannelId, message.getSid()).delete();
        }
    }
}
