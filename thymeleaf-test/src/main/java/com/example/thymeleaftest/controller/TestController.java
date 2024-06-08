package com.example.thymeleaftest.controller;

import com.example.thymeleaftest.dto.UserDto;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class TestController {
    @GetMapping("/")
    public String showTestPage(Model model) {
//        String variable = "Just another test :)";
//        model.addAttribute("variable", variable);

        List<String> items = Arrays.asList("t1", "t2", "t3");
        model.addAttribute("items", items);

//        boolean isValid = false;
//        model.addAttribute("condition", isValid);

//        model.addAttribute("color", "#0000FF");

//        model.addAttribute("userDto", new UserDto());

//        model.addAttribute("date", new Date());
//        model.addAttribute("number", 30.34235345);

        UserDto user = new UserDto();
        user.setName("Pesho");
        model.addAttribute("user", user);

        model.addAttribute("userDto", new UserDto());

        return "example";
    }

    @PostMapping("/")
    public String getUserName(UserDto userDto) {
        return "example";
    }
}
