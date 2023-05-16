package be.thomasmore.qrace.model;
import jakarta.persistence.*;

@Entity
@Table(name = "GAMES")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int raceId;

    private String host;
    private String player2;
    private String player3;
    private String player4;

    public Game(int raceId, String host, String player2, String player3, String player4) {
        this.raceId = raceId;
        this.host = host;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
    }

    public Game(int raceId) {
        this.raceId = raceId;
    }

    public Game() {

    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getPlayer3() {
        return player3;
    }

    public void setPlayer3(String player3) {
        this.player3 = player3;
    }

    public String getPlayer4() {
        return player4;
    }

    public void setPlayer4(String player4) {
        this.player4 = player4;
    }
}
