package be.thomasmore.qrace.repository;

import be.thomasmore.qrace.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
}

