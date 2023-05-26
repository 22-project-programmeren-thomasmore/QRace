package be.thomasmore.qrace.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class HighScores {
    @Id
    private Integer id;
    private String user_name;
    private Integer score;
    private Date highscore_date;


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return user_name;
    }

    public void setUsername(String username) {
        this.user_name = username;
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
