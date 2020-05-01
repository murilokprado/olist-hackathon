package com.hackathon.olist.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.hackathon.olist")
public class OlistApplication {

    public static void main(String[] args) {
        SpringApplication.run(OlistApplication.class, args);
    }

}
