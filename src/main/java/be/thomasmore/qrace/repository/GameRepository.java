package be.thomasmore.qrace.repository;

import be.thomasmore.qrace.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GameRepository extends JpaRepository<Game, Long> {

    <S extends Game> S save(S game);
}