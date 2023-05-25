package be.thomasmore.qrace.model;


import jakarta.persistence.*;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String username;
    private String email;
    private String passwoord;



    public User(String username, String email, String passwoord) {
        this.username = username;
        this.email = email;
        this.passwoord = passwoord;
    }

    public User() {

    }


    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswoord() {
        return passwoord;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswoord(String passwoord) {
        this.passwoord = passwoord;
    }
}
