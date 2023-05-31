package be.thomasmore.qrace.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Random;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playerID;
    private String name;
    private int score;
    private int currentCheckpoint;
    private long time;

    public Player(int playerID) {
        this.playerID = playerID;
    }

    public Player(String name) {
        this.name = name;
        this.playerID = generatePlayerID(); // Generate a unique player ID
    }

    public Player(int playerID, String name) {
        this.playerID = playerID;
        this.name = name;
        this.score = 0;
        this.currentCheckpoint = 0;
    }

    private int generatePlayerID() {
        Random random = new Random();
        return random.nextInt(900000) + 100000; // generate random 6-digit number
    }

        public void addScore(int score) {
        this.score += score;
    }

    public void addCheckpoint() {
        this.currentCheckpoint++;
    }

    public void removeCheckpoint() {
        this.currentCheckpoint--;
    }

    public void removeScore(int score) {
        this.score -= score;
    }

    public void resetScore() {
        this.score = 0;
    }

    public void resetCheckpoint() {
        this.currentCheckpoint = 0;
    }

    public void resetPlayer() {
        this.score = 0;
        this.currentCheckpoint = 0;
    }
}


