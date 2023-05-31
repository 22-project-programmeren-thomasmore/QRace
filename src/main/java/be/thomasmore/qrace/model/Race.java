package be.thomasmore.qrace.model;

import jakarta.persistence.*;
import be.thomasmore.qrace.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "RACES")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int raceID;
    private RaceStatusEnum status;
    @ManyToOne
    private Player player1;
    @ManyToOne
    private Player host;
    @OneToMany
    private List<Player> participants;
    private int totalQuestions;
    private int maxAttempts;
    private int remainingAttempts;
    private int playerScore;
    private String scannedQRCode;

    public Race(int raceID) {
        this.raceID = raceID;
    }

    public Race() {
    }

    public Race(int raceID, Player host) {
        this.raceID = raceID;
        this.host = host;
        this.participants = new ArrayList<>();
        this.remainingAttempts = 0;
        this.playerScore = 0;
    }

    public void addParticipant(Player participant) {
        this.participants.add(participant);
    }

    public void startRace() {
        performQRCodeScanning();
        // Set initial values for the race
        totalQuestions = 5;
        maxAttempts = 2;
        remainingAttempts = maxAttempts;

        // Start the race
        status = RaceStatusEnum.IN_PROGRESS;

        // Display the first question
        nextQuestion();
    }

    public void nextQuestion() {
        // Check if there are remaining questions
        if (totalQuestions > 0) {
            // Display the question
            String question = getQuestionFromDatabase(); // Replace with your logic to fetch the question
            System.out.println("Question: " + question);
            totalQuestions--;
        } else {
            // All questions have been answered
            finishRace();
        }
    }

    public void answerQuestion(String answer) {
        if (isAnswerCorrect(answer)) {
            // Correct answer
            playerScore += remainingAttempts == maxAttempts ? 3 : 1;
            System.out.println("Correct answer! Score: " + playerScore);
            remainingAttempts = maxAttempts;
        } else {
            // Wrong answer
            remainingAttempts--;

            if (remainingAttempts == 0) {
                // No more attempts left
                System.out.println("Wrong answer! No more attempts. Score: " + playerScore);
                nextQuestion();
            } else {
                // More attempts remaining
                System.out.println("Wrong answer! Try again. Remaining attempts: " + remainingAttempts);
            }
        }
    }

    private void performQRCodeScanning() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Scan the QR code:");
        String scannedValue = scanner.nextLine();

        // Validate the scanned value and perform necessary processing
        // ...

        // Set the scanned value as the scannedQRCode property
        setScannedQRCode(scannedValue);
    }

    public void setScannedQRCode(String scannedQRCode) {
        this.scannedQRCode = scannedQRCode;
    }

    private String getQuestionFromDatabase() {
        // Replace with your logic to fetch the question from the database
        return "Sample question";
    }

    private boolean isAnswerCorrect(String answer) {
        // Replace with your logic to check if the answer is correct
        return answer.equalsIgnoreCase("sample answer");
    }

    private void finishRace() {
        status = RaceStatusEnum.FINISHED;
        System.out.println("Race finished! Final score: " + playerScore);
    }
}
