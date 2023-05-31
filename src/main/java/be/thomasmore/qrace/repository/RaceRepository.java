package be.thomasmore.qrace.repository;

import be.thomasmore.qrace.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceRepository extends JpaRepository<Race, Integer> {
    Race findById(int raceID);
    <S extends Race> S save(S race);
}