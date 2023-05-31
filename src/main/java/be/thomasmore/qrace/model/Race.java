package be.thomasmore.qrace.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
        initializeRace();
        startNextQuestion();
    }

    public void startNextQuestion() {
        if (areQuestionsRemaining()) {
            displayQuestion();
            decrementTotalQuestions();
        } else {
            finishRace();
        }
    }

    public void submitAnswer(String answer) {
        if (isAnswerCorrect(answer)) {
            handleCorrectAnswer();
        } else {
            handleWrongAnswer();
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

    private void initializeRace() {
        totalQuestions = 5;
        maxAttempts = 2;
        remainingAttempts = maxAttempts;
        status = RaceStatusEnum.IN_PROGRESS;
    }

    private void displayQuestion() {
        String question = getQuestionFromDatabase(); // Replace with your logic to fetch the question
        System.out.println("Question: " + question);
    }

    private void decrementTotalQuestions() {
        totalQuestions--;
    }

    private boolean areQuestionsRemaining() {
        return totalQuestions > 0;
    }

    private boolean isAnswerCorrect(String answer) {
        // Replace with your logic to check if the answer is correct
        return answer.equalsIgnoreCase("sample answer");
    }

    private void handleCorrectAnswer() {
        playerScore += remainingAttempts == maxAttempts ? 3 : 1;
        System.out.println("Correct answer! Score: " + playerScore);
        remainingAttempts = maxAttempts;
        startNextQuestion();
    }

    private void handleWrongAnswer() {
        remainingAttempts--;

        if (remainingAttempts == 0) {
            System.out.println("Wrong answer! No more attempts. Score: " + playerScore);
            startNextQuestion();
        } else {
            System.out.println("Wrong answer! Try again. Remaining attempts: " + remainingAttempts);
        }
    }

    private void finishRace() {
        status = RaceStatusEnum.FINISHED;
        System.out.println("Race finished! Final score: " + playerScore);
    }

    private void setScannedQRCode(String scannedQRCode) {
        this.scannedQRCode = scannedQRCode;
    }

    private String getQuestionFromDatabase() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("qrace");
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Question> query = em.createQuery("SELECT q FROM Question q", Question.class);
            List<Question> questions = query.getResultList();

            // Get a random question from the list
            Random random = new Random();
            Question randomQuestion = questions.get(random.nextInt(questions.size()));

            return randomQuestion.getQuestionText();
        } finally {
            em.close();
            emf.close();
        }
    }

}
