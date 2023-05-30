package be.thomasmore.qrace.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "high_scores")
public class HighScores {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HIGHSCORE_SEQ")
    @SequenceGenerator(name = "HIGHSCORE_SEQ", sequenceName = "HIGHSCORE_SEQ", allocationSize = 1)
    private int id;
    @NotNull
    @Column(name = "user_name")
    private String userName;
    @NotNull
    private int score;

    @NotNull
    @Column(name = "highscore_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date highscoreDate;

    @Column(name = "archive")
    private boolean archive;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getHighscoreDate() {
        return this.highscoreDate;
    }

    public void setHighscoreDate(Date highscoreDate) {
        this.highscoreDate = highscoreDate;
    }

    public boolean getArchive() {
        return archive;
    }

    public void setArchive(boolean archive) {
        this.archive = archive;
    }
}
