package be.thomasmore.qrace.service;

import be.thomasmore.qrace.model.Game;
import be.thomasmore.qrace.repository.GameRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Random;

@Service
public class GameService {

    private final Map<String, Game> games = new ConcurrentHashMap<>();
    GameRepository gameRepository;
    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
    @Transactional
    public Game createGame() {
        Game game = new Game(generateRaceId());
        games.put(Integer.toString(game.getRaceId()), game);
        return game;
    }


    public Game findGameByRaceId(String raceId) {
        return games.get(raceId);
    }

    public int generateRaceId() {
        int randomId = new Random().nextInt(9000) + 1000;
        String sql = "INSERT INTO GAMES values (" + randomId + ", 1, 2, 3, 4)";
        entityManager.createNativeQuery(sql).executeUpdate();
        return randomId;
    }
}