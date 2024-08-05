package com.example.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class MessageTopicConfig {

    @Bean
    public NewTopic messagesTopic() {
        return TopicBuilder
                .name("messages")
                .build();
    }
}
