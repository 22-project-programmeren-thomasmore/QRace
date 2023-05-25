package be.thomasmore.qrace.controller;

import be.thomasmore.qrace.model.Question;
import be.thomasmore.qrace.service.QuestionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

  private final QuestionService questionService;

  @Autowired
  public QuestionController(QuestionService questionService) {
    this.questionService = questionService;
  }

  @GetMapping
  public ResponseEntity<List<Question>> getAllQuestions() {
    return ResponseEntity.ok(questionService.getAllQuestions());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
    return ResponseEntity.ok(questionService.getQuestionById(id));
  }

  @PostMapping
  public ResponseEntity<Question> createQuestion(
    @RequestBody Question question
  ) {
    return ResponseEntity.ok(questionService.saveQuestion(question));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Question> updateQuestion(
    @PathVariable Long id,
    @RequestBody Question question
  ) {
    Question existingQuestion = questionService.getQuestionById(id);
    if (existingQuestion == null) {
      return ResponseEntity.notFound().build();
    }
    question.setId(id);
    return ResponseEntity.ok(questionService.saveQuestion(question));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
    Question existingQuestion = questionService.getQuestionById(id);
    if (existingQuestion == null) {
      return ResponseEntity.notFound().build();
    }
    questionService.deleteQuestion(id);
    return ResponseEntity.ok().build();
  }
}
