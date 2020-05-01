package com.hackathon.olist.sendmessage;

import com.hackathon.olist.sendmessage.payload.MessageRequest;
import com.hackathon.olist.sendmessage.service.SendMessageService;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("send_message")
public class SendMessageController {

    private SendMessageService sendMessageService;

    public SendMessageController(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @PostMapping("sms")
    private Message sendMessage(@RequestBody MessageRequest messageRequest) {
        return sendMessageService.sendSms(messageRequest);
    }

    @PostMapping("whatsapp")
    private Message sendWhatsapp(@RequestBody MessageRequest messageRequest) {
        return sendMessageService.sendWhatsapp(messageRequest);
    }
}
