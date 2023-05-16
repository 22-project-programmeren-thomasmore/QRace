package be.thomasmore.qrace.repositories;

import be.thomasmore.qrace.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ThreadLocalRandom;

@Repository
    public interface PlayerRepository extends JpaRepository<Player, Integer> {

        default int generateRandomPlayerID() {
            return ThreadLocalRandom.current().nextInt(100000, 1000000);
        }

        default Player savePlayerWithName(String name) {
            Player player = new Player();
            player.setName(name);
            player.setPlayerId(generateRandomPlayerID());
            return save(player);
        }
    }
