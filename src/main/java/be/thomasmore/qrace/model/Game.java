package be.thomasmore.qrace.model;
import jakarta.persistence.*;

@Entity
@Table(name = "GAMES")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String raceId;


    public Game(String raceId) {
        this.raceId = raceId;
    }

    public Game() {

    }

    public String getRaceId() {
        return raceId;
    }
}
