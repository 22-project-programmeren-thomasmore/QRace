package be.thomasmore.qrace.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
// de structuur van de vragen binnen de Quiz
public class Question {
    String prompt;
    String answer;
}

