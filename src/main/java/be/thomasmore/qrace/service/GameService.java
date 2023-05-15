package be.thomasmore.qrace.service;

import be.thomasmore.qrace.model.Game;
import be.thomasmore.qrace.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Random;

@Service
public class GameService {

    private final Map<String, Game> games = new ConcurrentHashMap<>();
    RaceRepository raceRepository;
    @Autowired
    public GameService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public Game createGame() {
        Game game = new Game(generateRaceId());
        games.put(game.getRaceId(), game);
        return game;
    }


    public Game findGameByRaceId(String raceId) {
        return games.get(raceId);
    }

    private int generateRaceId() {
        int randomId = new Random().nextInt(10000);
        String sql = "INSERT INTO GAMES values  (" + randomId + ", 1, 2, 3, 4)";

        return randomId;
    }
}