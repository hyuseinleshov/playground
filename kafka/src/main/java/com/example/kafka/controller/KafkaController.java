package com.example.kafka.controller;

import com.example.kafka.dto.Greeting;
import com.example.kafka.producer.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    private final KafkaProducer kafkaProducerService;

    public KafkaController(KafkaProducer kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/message")
    public ResponseEntity<String> sendMessage(
            @RequestBody String message
    ) {
        kafkaProducerService.sendMessage(message);
        return ResponseEntity.ok("Message queued successfully");
    }

    @PostMapping("/greeting")
    public ResponseEntity<String> publishGreeting(
            @RequestBody Greeting greeting
    ) {
        kafkaProducerService.sendGreeting(greeting);
        return ResponseEntity.ok("Greeting queued successfully");
    }
}
