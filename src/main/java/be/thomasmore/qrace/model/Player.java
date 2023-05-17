package be.thomasmore.qrace.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
@Builder
public class Player {

  @Id
  @Column(name = "player_id")
  private String playerID;

  @Column(name = "player_name")
  private String name;

  @ManyToOne
  @JoinColumn(name = "mascot_id")
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
