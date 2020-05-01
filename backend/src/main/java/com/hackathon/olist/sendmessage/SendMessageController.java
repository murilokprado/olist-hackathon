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

    @GetMapping
    public List<Client> getObject() {
        Client client = new Client();
        client.setId(1);
        client.setName("Murilo");
        client.setPhone("47XXXXXXXX");

        Client client2 = new Client();
        client2.setId(2);
        client2.setName("Valenza");
        client2.setPhone("47XXXXXXX");

        List<Client> clients = new ArrayList<>();
        clients.add(client);
        clients.add(client2);

        return clients;
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
