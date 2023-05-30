package be.thomasmore.qrace.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int raceID;

    @ManyToOne
    private Player host;

    @OneToMany(mappedBy = "quizSession", cascade = CascadeType.ALL)
    private List<Player> participants;

    @OneToMany(mappedBy = "quizSession", cascade = CascadeType.ALL)
    private List<Question> questions;

    // Constructors, getters, and setters

    public Race() {
        this.participants = new ArrayList<>();
        this.questions = new ArrayList<>();
    }

    public Race(int raceID, Player host) {
        this.raceID = raceID;
        this.host = host;
        this.participants = new ArrayList<>();
        this.participants.add(host);
        this.questions = new ArrayList<>();
    }

    public int getID() {
        return raceID;
    }

    public void setRaceID(int raceID) {
        this.raceID = raceID;
    }

    public Player getHost() {
        return host;
    }

    public void setHost(Player host) {
        this.host = host;
    }

    public List<Player> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Player> participants) {
        this.participants = participants;
    }

    public void addParticipant(Player participant) {
        this.participants.add(participant);
    }

    public void removeParticipant(Player participant) {
        this.participants.remove(participant);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
        question.setRace(this);
    }
}

