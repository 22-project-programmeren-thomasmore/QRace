package be.thomasmore.qrace.repository;


import be.thomasmore.qrace.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUSERNAME(String USERNAME );
}
