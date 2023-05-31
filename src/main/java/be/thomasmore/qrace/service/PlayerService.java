package be.thomasmore.qrace.service;

import be.thomasmore.qrace.model.Player;
import be.thomasmore.qrace.repository.PlayerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PlayerService {
    private final Map<String, Player> players = new ConcurrentHashMap<>();
    private PlayerRepository playerRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public int generatePlayerID() {
        int randomPlayerID = new Random().nextInt(9000) + 1000;
        String sql = "INSERT INTO PLAYERS values (" + randomPlayerID + ", 1, 2, 3, 4)";
        entityManager.createNativeQuery(sql).executeUpdate();
        return randomPlayerID;
    }

    public Player createPlayer() {
        Player player = new Player(generatePlayerID(), createPlayer().getName());
        players.put(Integer.toString(player.getPlayerID()), player);
        playerRepository.save(player);
        return player;
    }


}
