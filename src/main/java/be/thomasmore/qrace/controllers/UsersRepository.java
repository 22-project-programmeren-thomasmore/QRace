package be.thomasmore.qrace.controllers;


import be.thomasmore.qrace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long>{
}
