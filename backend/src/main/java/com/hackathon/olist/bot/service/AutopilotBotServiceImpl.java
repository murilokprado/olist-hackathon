package com.hackathon.olist.bot.service;

import com.hackathon.olist.bot.AutopilotBotFactory;
import com.hackathon.olist.bot.payload.MessageResponse;
import com.hackathon.olist.sendmessage.payload.MessageRequest;
import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.exception.ApiException;
import com.twilio.rest.chat.v2.service.Channel;
import com.twilio.rest.chat.v2.service.channel.Member;
import com.twilio.rest.chat.v2.service.channel.Message;
import com.twilio.rest.chat.v2.service.channel.Webhook;
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

    @Value("${twilio.service.id}")
    private String twilioChannelUrl;

    private AutopilotBotFactory autopilotBotFactory;

    public AutopilotBotServiceImpl(AutopilotBotFactory autopilotBotFactory) {
        this.autopilotBotFactory = autopilotBotFactory;
    }

    @Override
    public List<MessageResponse> getMessages() {
        Twilio.init(twilioId, twilioToken);

        Channel channel = createChannel();

        ResourceSet<Message> resourceMessages = Message.reader(twilioServiceId, channel.getSid())
                .limit(100)
                .read();

        return autopilotBotFactory.create(resourceMessages);
    }

    @Override
    public Message createMessage(MessageRequest messageRequest) {
        Twilio.init(twilioId, twilioToken);
        Channel channel = createChannel();
        Webhook webhook = createWebhook(channel);

        return Message
                .creator(channel.getServiceSid(), channel.getSid())
                .setBody(messageRequest.getMessage())
                .setFrom("user")
                .create();
    }

    private void deleteMessages(ResourceSet<Message> resourceMessages) {
        for (Message message : resourceMessages) {
            Message.deleter(message.getServiceSid(), message.getChannelSid(), message.getSid()).delete();
        }
    }

    private Channel createChannel() {

        try {
            return Channel.fetcher(twilioServiceId, "rest-api").fetch();
        } catch (ApiException e) {
        }

        return Channel.creator(twilioServiceId)
                .setFriendlyName("Canal da API")
                .setUniqueName("rest-api")
                .create();
    }

    private Member createMember(Channel channel) {
        try {
            return Member.fetcher(twilioServiceId, channel.getSid(), "user").fetch();
        } catch (ApiException e) {
        }

        return Member.creator(twilioServiceId, channel.getSid(), "user").create();
    }

    private Webhook createWebhook(Channel channel) {
        ResourceSet<Webhook> webhooks = Webhook.reader(twilioServiceId, channel.getSid()).read();

        if (webhooks.iterator().hasNext()) {
            return Webhook.fetcher(twilioServiceId, channel.getSid(), webhooks.iterator().next().getSid()).fetch();
        } else {
            for (Webhook webhook : webhooks) {
                Webhook.deleter(webhook.getServiceSid(), webhook.getChannelSid(), webhook.getSid()).delete();
            }
        }

        return Webhook.creator(
                twilioServiceId,
                channel.getSid(),
                Webhook.Type.WEBHOOK)
                .setConfigurationFilters(Arrays.asList("onMessageSent"))
                .setConfigurationMethod(Webhook.Method.POST)
                .setConfigurationUrl(twilioChannelUrl)
                .create();
    }
}
