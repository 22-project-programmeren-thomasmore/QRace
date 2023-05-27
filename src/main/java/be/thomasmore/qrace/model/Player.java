package be.thomasmore.qrace.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
@Builder
public class Player {
    @Id
    private String playerID;
    private String name;
    @OneToOne
    private Mascot chosenMascot;
    private int score;
    private int currentCheckpoint;


    public Player() {

    }

    public Player(String playerID, String name, Mascot chosenMascot) {
        this.playerID = playerID;
        this.name = name;
        this.chosenMascot = chosenMascot;
        this.score = 0;
        this.currentCheckpoint = 0;
    }


    public int getCurrentCheckpoint() {
        return currentCheckpoint;
    }

    public void setCurrentCheckpoint(int currentCheckpoint) {
        this.currentCheckpoint = currentCheckpoint;
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

    public void movePlayer(boolean isAnswerCorrect) {
        if (isAnswerCorrect) {
            // Increment the current checkpoint
            currentCheckpoint++;
        } else {
            // Decrement the current checkpoint unless the player is at the start
            if (currentCheckpoint > 0) {
                currentCheckpoint--;
            }
        }
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
}

