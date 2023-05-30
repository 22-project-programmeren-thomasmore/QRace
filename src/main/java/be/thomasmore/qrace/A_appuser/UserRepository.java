package be.thomasmore.qrace.A_appuser;


import be.thomasmore.qrace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<AppUsers, Long>{

    Optional<AppUsers> findByEmail(String email);
}
