package com.example.team_5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StartController {
    @GetMapping("/")
    public String showStartPage() {
        return "start";
    }

//    @PostMapping("/start")
//    public String handleStartFormSubmission() {
//
//        return "redirect:/game";
//    }
}
