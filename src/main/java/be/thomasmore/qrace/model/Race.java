package be.thomasmore.qrace.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Race {
  @Id
  private String raceID;
  private RaceStatusEnum status;
  private Player hostPlayer;
  private Player secondPlayer;
  private Player thirdPlayer;
  private Player fourthPlayer;
  private Player winner;

  public Race(String raceID) {
    this.raceID = raceID;
  }
  public String getRaceID() {
    return raceID;
  }
  public void setRaceID(String raceID) {
    this.raceID = raceID;
  }

  public Race(Player hostPlayer){
    this.hostPlayer = hostPlayer;
  }

  public Race(Player hostPlayer, Player secondPlayer){
    this.hostPlayer = hostPlayer;
    this.secondPlayer = secondPlayer;
  }

  public Race(Player hostPlayer, Player secondPlayer, Player thirdPlayer){
    this.hostPlayer = hostPlayer;
    this.secondPlayer = secondPlayer;
  }

  public Race(Player hostPlayer, Player secondPlayer, Player thirdPlayer, Player fourthPlayer){
    this.hostPlayer = hostPlayer;
    this.secondPlayer = secondPlayer;
    this.thirdPlayer = thirdPlayer;
    this.fourthPlayer = fourthPlayer;
  }
}