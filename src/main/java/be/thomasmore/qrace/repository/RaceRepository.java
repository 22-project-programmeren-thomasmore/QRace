package be.thomasmore.qrace.repository;

import be.thomasmore.qrace.model.Race;
import org.springframework.data.repository.CrudRepository;

public interface RaceRepository extends CrudRepository<Race, String> {
}
