package com.example.team_5.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class StartController {
    @GetMapping("/")
    public String showsStartPage() {
        return "start";
    }
}
