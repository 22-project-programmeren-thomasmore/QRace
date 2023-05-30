package be.thomasmore.qrace.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "questions")
public class Question {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private Race race;

  @NotNull
  @Column(name = "question_text")
  private String questionText;

  @Column(name = "answer1")
  private String answer1;

  @Column(name = "answer2")
  private String answer2;

  @Column(name = "answer3")
  private String answer3;

  @Column(name = "answer4")
  private String answer4;

  @NotNull
  @Column(name = "correct_answer")
  private String correctAnswer;

  @NotNull
  @Column(name = "group_parameter")
  private String groupParameter;

  @NotNull
  @Column(name = "language")
  private String language;

  @Column(name = "archived")
  private boolean archived = false;

  // getters and setters...

  public boolean isArchived() {
    return archived;
  }

  public void setArchived(boolean archived) {
    this.archived = archived;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getQuestionText() {
    return questionText;
  }

  public void setQuestionText(String questionText) {
    this.questionText = questionText;
  }

  public String getAnswer1() {
    return answer1;
  }

  public void setAnswer1(String answer1) {
    this.answer1 = answer1;
  }

  public String getAnswer2() {
    return answer2;
  }

  public void setAnswer2(String answer2) {
    this.answer2 = answer2;
  }

  public String getAnswer3() {
    return answer3;
  }

  public void setAnswer3(String answer3) {
    this.answer3 = answer3;
  }

  public String getAnswer4() {
    return answer4;
  }

  public void setAnswer4(String answer4) {
    this.answer4 = answer4;
  }

  public String getCorrectAnswer() {
    return correctAnswer;
  }

  public void setCorrectAnswer(String correctAnswer) {
    this.correctAnswer = correctAnswer;
  }

  public String getGroupParameter() {
    return groupParameter;
  }

  public void setGroupParameter(String groupParameter) {
    this.groupParameter = groupParameter;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public Race getRace() {
    return race;
  }

  public void setRace(Race race) {
    this.race = race;
  }
}
