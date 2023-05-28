package be.thomasmore.qrace.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.time.StopWatch;

@Entity // Add this annotation
@AllArgsConstructor
@Data
@Builder
public class Race {
    @Id
    private String raceID;
    private RaceStatusEnum status;
    @ManyToOne
    private Player hostPlayer;
    @ManyToOne
    private Player secondPlayer;
    @ManyToOne
    private Player thirdPlayer;
    @ManyToOne
    private Player fourthPlayer;
    @ManyToOne
    private Player winner;

    public Race(String raceID) {
        this.raceID = raceID;
    }

    public Race() {

    }

    public String getRaceID() {
        return raceID;
    }

    public void setRaceID(String raceID) {
        this.raceID = raceID;
    }

    public Race(Player hostPlayer) {
        this.hostPlayer = hostPlayer;
    }

    public Race(Player hostPlayer, Player secondPlayer) {
        this.hostPlayer = hostPlayer;
        this.secondPlayer = secondPlayer;
    }

    public Race(Player hostPlayer, Player secondPlayer, Player thirdPlayer) {
        this.hostPlayer = hostPlayer;
        this.secondPlayer = secondPlayer;
    }

    public Race(Player hostPlayer, Player secondPlayer, Player thirdPlayer, Player fourthPlayer) {
        this.hostPlayer = hostPlayer;
        this.secondPlayer = secondPlayer;
        this.thirdPlayer = thirdPlayer;
        this.fourthPlayer = fourthPlayer;
    }

    public void startStopWatch() {
        StopWatch watch = new StopWatch();
        watch.start();
    }

    public void stopStopWatch() {
        StopWatch watch = new StopWatch();
        watch.stop();
        System.out.println(watch.getTime());
    }
}