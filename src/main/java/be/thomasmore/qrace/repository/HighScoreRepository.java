package be.thomasmore.qrace.repository;
import be.thomasmore.qrace.model.HighScores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HighScoreRepository extends JpaRepository<HighScores, Long> {
}