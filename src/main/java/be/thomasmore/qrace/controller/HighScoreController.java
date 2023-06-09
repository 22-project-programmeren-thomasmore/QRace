package be.thomasmore.qrace.controller;

import be.thomasmore.qrace.model.HighScores;
import be.thomasmore.qrace.repository.HighScoreRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
// @RequestMapping("/api/highscores")
public class HighScoreController {
    private final HighScoreRepository highScoreRepository;

    public HighScoreController(HighScoreRepository highScoreRepository) {
        this.highScoreRepository = highScoreRepository;
    }

    @GetMapping("/highscore")
    public String highscore(Model model) {
        List<HighScores> highscores = highScoreRepository.findAll();
        // System.out.println(highscores);
        model.addAttribute("highscores", highScoreRepository.findAll());
        return "admin/highscore";
    }

    @GetMapping("/scoreboard")
    public String scoreBoard(Model model) {
        List<HighScores> highscores = highScoreRepository.findAll();
        // System.out.println(highscores);
        model.addAttribute("highscores", highScoreRepository.findAll());
        return "scoreboard";
    }

    @ModelAttribute("highscore")
    public HighScores highScore() {
        return new HighScores();
    }

    @PostMapping("/highscore")
    public String submitHighscore(@ModelAttribute HighScores highscore) {
        highScoreRepository.save(highscore);
        return "redirect:highscore"; // return "redirect:admin/highscore";
    }

    @PostMapping("/updateHighscore")
    public ResponseEntity<Void> updateHighscore(@RequestBody HighScores updatedHighscore) {
        HighScores existingHighscore = highScoreRepository.findById(updatedHighscore.getId()).orElse(null);
        if (existingHighscore != null) {
            existingHighscore.setUserName(updatedHighscore.getUserName());
            existingHighscore.setScore(updatedHighscore.getScore());
            existingHighscore.setHighscoreDate(updatedHighscore.getHighscoreDate());
            existingHighscore.setArchive(updatedHighscore.getArchive());
            highScoreRepository.save(existingHighscore);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/highscores/{id}")
    public ResponseEntity<Void> deleteHighScore(@PathVariable("id") Integer id) {
        // Check if the highscore exists
        if (highScoreRepository.existsById(id)) {
            highScoreRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
