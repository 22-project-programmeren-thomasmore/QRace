package be.thomasmore.qrace.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class HighScores {
    @Id
    private Integer id;
    private String username;
    private Integer score;
    private Date highscore_date;


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getHighscore_date() {
        return highscore_date;
    }

    public void setHighscore_date(Date highscore_date) {
        this.highscore_date = highscore_date;
    }
}
