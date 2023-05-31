package be.thomasmore.qrace.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
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
    private Player host;
    @OneToMany
    private List<Player> participants;

    public Race(int raceID) {
        this.raceID = raceID;
    }

    public Race() {
    }

    public Race(int raceID, Player host) {
        this.raceID = raceID;
        this.host = host;
        this.participants = new ArrayList<>();
        this.participants.add(host);
    }

    public void addParticipant(Player participant) {
        this.participants.add(participant);
    }
}
