package be.thomasmore.team_5.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Race {
    @Id
    private Integer id;
    private String raceName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
