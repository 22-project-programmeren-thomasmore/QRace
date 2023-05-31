package be.thomasmore.qrace.repository;

import be.thomasmore.qrace.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RaceRepository extends JpaRepository<Race, Integer> {
    Optional<Race> findById(int raceID);
    <S extends Race> S save(S race);
}