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
    private Long id;
    @NotNull
    @Column(name = "user_name")
    private String userName;
    @NotNull
    private Long score;
    @NotNull
    @Column(name = "highscore_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date highscoreDate;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public Date getHighscoreDate() {
        return this.highscoreDate;
    }

    public void setHighscoreDate(Date highscoreDate) {
        this.highscoreDate = highscoreDate;
    }
}