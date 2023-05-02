package com.example.team_5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class Team5Application {

    public static void main(String[] args) {
        SpringApplication.run(Team5Application.class, args);
    }

    @GetMapping("/")
    @ResponseBody
    public String helloWorld(){
        return "Hello render - qRace";
    }

}
