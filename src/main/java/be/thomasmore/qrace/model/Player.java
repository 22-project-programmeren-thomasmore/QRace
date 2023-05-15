package be.thomasmore.qrace.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Player {
    @Id
    private String playerID;
    private String name;
    private Mascot chosenMascot;
    private int score;

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

