package be.thomasmore.qrace.controller;

import be.thomasmore.qrace.model.HighScores;
import be.thomasmore.qrace.repository.HighScoreRepository;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
//@RequestMapping("/api/highscores")
public class HighScoreController {
    private final HighScoreRepository highScoreRepository;
    public HighScoreController(HighScoreRepository highScoreRepository) {
        this.highScoreRepository = highScoreRepository;
    }

    @GetMapping("/highscore")
    public String highscore(Model model) {
        List<HighScores> highscores = highScoreRepository.findAll();
        System.out.println(highscores);
        model.addAttribute("highscores", highScoreRepository.findAll());
        return "highscore";
    }

}
