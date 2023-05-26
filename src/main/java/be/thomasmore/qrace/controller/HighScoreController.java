package be.thomasmore.qrace.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/api/highscores")
public class HighScoreController {

    @GetMapping("/highscore")
    public String highscore(Model model) {
        int test = 1;
        return "highscore";
    }

}
