package com.example.kafka.producer;

import com.example.kafka.dto.Greeting;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, Greeting> greetingKafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate, KafkaTemplate<String, Greeting> greetingKafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.greetingKafkaTemplate = greetingKafkaTemplate;
    }

    // String
    public void sendMessage(String message) {
        kafkaTemplate.send("test", message);
    }

    // Greeting(Json)
    public void sendGreeting(Greeting greeting) {
        Message<Greeting> message = MessageBuilder
                .withPayload(greeting)
                .setHeader(KafkaHeaders.TOPIC, "test")
                .build();
        greetingKafkaTemplate.send(message);
    }
}
