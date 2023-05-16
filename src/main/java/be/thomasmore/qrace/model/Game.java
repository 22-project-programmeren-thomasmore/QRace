package be.thomasmore.qrace.model;
import jakarta.persistence.*;

@Entity
@Table(name = "GAMES")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int raceId;


    public Game(int raceId) {
        this.raceId = raceId;
    }

    public Game() {

    }

    public int getRaceId() {
        return raceId;
    }
}
