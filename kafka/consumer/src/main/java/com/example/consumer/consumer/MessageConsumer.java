package com.example.consumer.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @KafkaListener(topics = "messages", groupId = "my-group")
    public void consumeMessage(String message) {
        System.out.println("Consuming message from messages topic: " + message);
    }
}
