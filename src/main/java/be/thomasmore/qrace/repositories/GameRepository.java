package be.thomasmore.qrace.repositories;

import be.thomasmore.qrace.model.Race;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface GameRepository extends CrudRepository<Race, String> {
}
