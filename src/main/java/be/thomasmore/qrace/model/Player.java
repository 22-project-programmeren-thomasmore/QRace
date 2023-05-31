package be.thomasmore.qrace.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Player {
    @Id
    private int playerID;
    private String name;
    private int score;
    private int currentCheckpoint;
    private long time;

    public Player(int playerID) {
        this.playerID = playerID;
    }

    public Player(int playerID, String name) {
        this.playerID = playerID;
        this.name = name;
        this.score = 0;
        this.currentCheckpoint = 0;
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


