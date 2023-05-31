package be.thomasmore.qrace.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")

public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String USERNAME;
    private String PASSWORD;
    private String ROLE;

    public Users(String USERNAME, String PASSWORD, String ROLE) {
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
        this.ROLE = ROLE;
    }

    public String getRole() {
        return "USER";
    }
}
