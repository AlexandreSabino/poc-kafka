package com.netshoes.kafka.poc.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@RestController
public class PubKafka {

    @Autowired
    private KafkaTemplate<Integer, String> template;

    @RequestMapping(path = "publish")
    public String publishMessage() throws ExecutionException, InterruptedException {
        ListenableFuture<SendResult<Integer, String>> future = template.send("test", UUID.randomUUID().toString());
        return future.get().getProducerRecord().toString();
    }
}
