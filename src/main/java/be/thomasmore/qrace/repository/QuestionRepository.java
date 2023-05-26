package be.thomasmore.qrace.repository;

import be.thomasmore.qrace.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
  Question findByGroupParameter(String group);
}
