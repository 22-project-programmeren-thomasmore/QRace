package be.thomasmore.qrace.repository;

import be.thomasmore.qrace.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    // Additional custom methods for querying or manipulating player data can be defined here
}

