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
    if (sortBy != null) {
      return questionRepository.findAll(Sort.by(sortBy));
    } else {
      return questionRepository.findAll();
    }
  }
}
