package com.example.thymeleaftest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/")
    public String showTestPage(Model model) {
        String variable = "Just another test :)";
        model.addAttribute("variable", variable);

        return "test";
    }
}
