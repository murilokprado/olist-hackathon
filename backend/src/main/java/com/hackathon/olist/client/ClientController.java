package com.hackathon.olist.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("client")
public class ClientController {

    @GetMapping
    private List<Client> getObject() {
        Client client = new Client();
        client.setId(1);
        client.setName("Murilo");
        client.setPhone("47XXXXXXXX");

        Client client2 = new Client();
        client2.setId(2);
        client2.setName("Valenza");
        client2.setPhone("47XXXXXXX");


        return List.of(client, client2);
    }
}
