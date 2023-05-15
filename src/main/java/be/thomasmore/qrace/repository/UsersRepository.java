package be.thomasmore.qrace.repository;


import be.thomasmore.qrace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long>{
}
