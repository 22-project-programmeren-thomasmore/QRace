package be.thomasmore.qrace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HighScoreController {
    @GetMapping("/highscore")
    public String highscore() {
        int test = 1;
        return "highscore";
    }
}
