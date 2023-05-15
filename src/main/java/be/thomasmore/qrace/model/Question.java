package be.thomasmore.qrace.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
// de structuur van de vragen binnen de Quiz

public class Question {
    String url; //url van qrcode linken aan een vraag
    Player player; //player die de vraag moet beantwoorden
    String prompt;
    String firstAnswer;
    String secondAnswer;
}

