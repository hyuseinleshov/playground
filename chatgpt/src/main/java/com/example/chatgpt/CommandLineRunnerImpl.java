package com.example.chatgpt;

import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    @Autowired
    OpenAiChatModel chatModel;

    @Override
    public void run(String... args) throws Exception {
        Prompt prompt = new Prompt("Tell me a programmer joke that is funny!");
        ChatResponse response = chatModel.call(prompt);
        System.out.println(response.getResult().getOutput());
    }
}
