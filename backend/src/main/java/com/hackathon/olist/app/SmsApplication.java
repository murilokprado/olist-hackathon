package com.hackathon.olist.app;

import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Redirect;
import org.springframework.stereotype.Component;

import static spark.Spark.post;

@Component
public class SmsApplication {

    public SmsApplication() {
        post("/sms", (req, res) -> {
            res.type("application/xml");

            Body body = new Body
                    .Builder("Sua resposta foi enviada para a Larissa, sabia que as suas chances em fechar um negócio aumentaram em 14%?! Você é fera!\n" +
                    "&#xA;\n" +
                    "Se quiser mais detalhes sobre a resposta acesse: https://olist-hackaton.now.sh/message/1")
                    .build();

            com.twilio.twiml.messaging.Message sms = new com.twilio.twiml.messaging.Message
                    .Builder()
                    .body(body)
                    .build();

            MessagingResponse twiml = new MessagingResponse
                    .Builder()
                    .message(sms)
                    .build();

            return twiml.toXml();
        });
    }
}
