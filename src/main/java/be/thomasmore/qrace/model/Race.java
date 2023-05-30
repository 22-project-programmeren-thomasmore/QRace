package be.thomasmore.qrace.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "RACES")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int raceID;
    private RaceStatusEnum status;
    @ManyToOne
    private Player player1;
    @ManyToOne
    private Player player2;
    @ManyToOne
    private Player player3;
    @ManyToOne
    private Player player4;


    public Race(int raceID) {
        this.raceID = raceID;
    }
}
