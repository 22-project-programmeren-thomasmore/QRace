package be.thomasmore.qrace.controller;

import be.thomasmore.qrace.model.Player;
import be.thomasmore.qrace.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreController {

    @Autowired
    private PlayerRepository playerRepository;

    @PostMapping("/race")
    public ResponseEntity<String> saveScore(@RequestParam int playerID, @RequestParam Long time) {
        Player player = playerRepository.findById(Long.valueOf(playerID)).orElse(null);
        if (player == null) {
            return ResponseEntity.badRequest().body("Player not found");
        }

        player.setTime(time); // Set the player's score to the total time
        playerRepository.save(player);
        return ResponseEntity.ok("Score saved successfully");
    }
}

