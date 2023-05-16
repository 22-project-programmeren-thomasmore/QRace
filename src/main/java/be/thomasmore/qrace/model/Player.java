package be.thomasmore.qrace.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Random;
import java.util.List;
import java.util.Scanner;


@AllArgsConstructor
@Data
@Builder
public class Player {
    @Id
    private String playerID;
    private String name;
    private Mascot chosenMascot;
    private int score;

    public Player(String playerID, String name, Mascot chosenMascot) {
        this.playerID = playerID;
        this.name = name;
        this.chosenMascot = chosenMascot;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public Mascot getChosenMascot() {
        return chosenMascot;
    }

    public void setChosenMascot(Mascot chosenMascot) {
        this.chosenMascot = chosenMascot;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public void answerQuestion(Question question) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(question.getPrompt());
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase(question.getAnswer())) {
            score += 3;
            System.out.println("Correct! You earned 3 points.");
        } else {
            System.out.println("Incorrect! The correct answer is: " + question.getAnswer());
        }
    }

    public void receiveQuestions(List<Question> questions) {
        Random random = new Random();

        for (Question question : questions) {
            int randomIndex = random.nextInt(questions.size());
            Question randomQuestion = questions.get(randomIndex);

            answerQuestion(randomQuestion);
        }
    }
}

