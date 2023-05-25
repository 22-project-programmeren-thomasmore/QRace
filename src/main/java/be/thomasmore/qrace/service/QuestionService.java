package be.thomasmore.qrace.service;

import be.thomasmore.qrace.model.Question;
import be.thomasmore.qrace.repository.QuestionRepository;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

  private final QuestionRepository questionRepository;

  public QuestionService(QuestionRepository questionRepository) {
    this.questionRepository = questionRepository;
  }

  public List<Question> getAllQuestions() {
    return questionRepository.findAll();
  }

  public Question getQuestionById(Long id) {
    return questionRepository.findById(id).orElse(null);
  }

  public Question saveQuestion(Question question) {
    return questionRepository.save(question);
  }

  public void deleteQuestion(Long id) {
    questionRepository.deleteById(id);
  }

  public List<Question> getQuestionsSorted(String sortBy) {
    if (sortBy == null || sortBy.isEmpty()) {
      // If sortBy is null or empty, return the questions without sorting
      return questionRepository.findAll();
    } else {
      // If sortBy is not null or empty, return the questions sorted by sortBy
      Sort sort = Sort.by(sortBy).ascending();
      return questionRepository.findAll(sort);
    }
  }
}
