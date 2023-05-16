package be.thomasmore.qrace.repository;

import be.thomasmore.qrace.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceRepository extends JpaRepository<Game, Long> {

    <S extends Game> S save(S game);
}
