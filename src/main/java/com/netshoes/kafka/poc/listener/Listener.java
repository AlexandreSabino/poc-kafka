package com.netshoes.kafka.poc.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    @KafkaListener(topics = "test")
    public void listen(String data) {
        System.out.println("Listener: " +  data);
    }
}
