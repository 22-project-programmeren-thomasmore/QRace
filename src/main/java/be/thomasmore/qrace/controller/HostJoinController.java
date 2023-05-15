package be.thomasmore.qrace.controller;

import be.thomasmore.qrace.model.Game;
import be.thomasmore.qrace.service.GameService;
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
    public Game startGame() {
        return gameService.createGame();
    }

    @GetMapping("/join/{raceId}")
    public Game joinGame(@PathVariable String raceId) {
        Game game = gameService.findGameByRaceId(raceId);
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
