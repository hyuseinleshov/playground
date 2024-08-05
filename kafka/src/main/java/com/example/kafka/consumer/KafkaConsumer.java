package com.example.kafka.consumer;

import com.example.kafka.dto.Greeting;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "test", groupId = "my-group")
    public void consumeMessage(String message) {
        System.out.println("Consuming message from test topic: " + message);
    }

    @KafkaListener(topics = "test", groupId = "my-group")
    public void consumeGreeting(Greeting greeting) {
        System.out.println("Consuming Greeting from test topic: " + greeting);
    }
}
