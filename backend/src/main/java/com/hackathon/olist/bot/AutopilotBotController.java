package com.hackathon.olist.bot;

import com.hackathon.olist.bot.payload.MessageResponse;
import com.hackathon.olist.bot.service.AutopilotBotService;
import com.hackathon.olist.sendmessage.payload.MessageRequest;
import com.twilio.rest.chat.v2.service.channel.Message;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bot")
public class AutopilotBotController {

    private AutopilotBotService autopilotBotService;

    public AutopilotBotController(AutopilotBotService autopilotBotService) {
        this.autopilotBotService = autopilotBotService;
    }

    @GetMapping
    public List<MessageResponse> getMessages() {
        return autopilotBotService.getMessages();
    }

    @PostMapping
    public Message createMessage(@RequestBody MessageRequest messageRequest) {
        return autopilotBotService.createMessage(messageRequest);
    }
}
