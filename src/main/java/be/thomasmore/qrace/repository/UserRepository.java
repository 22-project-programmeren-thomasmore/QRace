package be.thomasmore.qrace.repository;


import be.thomasmore.qrace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
}
