package be.thomasmore.qrace.services;

import be.thomasmore.qrace.model.GameModel;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Random;

@Service
public class GameService {

    private final Map<String, GameModel> games = new ConcurrentHashMap<>();

    public GameModel createGame() {
        GameModel game = new GameModel(generateRaceId());
        games.put(game.getRaceId(), game);
        return game;
    }

    public GameModel findGameByRaceId(String raceId) {
        return games.get(raceId);
    }

    private String generateRaceId() {
        return String.format("%04d", new Random().nextInt(10000));
    }
}