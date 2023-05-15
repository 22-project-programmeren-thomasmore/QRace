package be.thomasmore.qrace.service;

import be.thomasmore.qrace.model.Game;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Random;

@Service
public class GameService {

    private final Map<String, Game> games = new ConcurrentHashMap<>();

    public Game createGame() {
        Game game = new Game(generateRaceId());
        games.put(game.getRaceId(), game);
        return game;
    }

    public Game findGameByRaceId(String raceId) {
        return games.get(raceId);
    }

    private String generateRaceId() {
        return String.format("%04d", new Random().nextInt(10000));
    }
}