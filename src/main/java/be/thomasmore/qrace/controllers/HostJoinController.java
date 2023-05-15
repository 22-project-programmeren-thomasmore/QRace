package be.thomasmore.qrace.controllers;

import be.thomasmore.qrace.model.GameModel;
import be.thomasmore.qrace.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/game")
public class HostJoinController {
    private final GameService gameService;

    public HostJoinController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/host")
    public GameModel startGame() {
        return gameService.createGame();
    }

    @GetMapping("/join/{raceId}")
    public GameModel joinGame(@PathVariable String raceId) {
        GameModel game = gameService.findGameByRaceId(raceId);
        if (game != null) {
            return game;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found");
        }
    }

    @GetMapping("/host-join")
    public String hostJoinPage() {
        return "host-join";
    }


}
