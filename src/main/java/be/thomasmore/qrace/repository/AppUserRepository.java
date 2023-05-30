package be.thomasmore.qrace.repository;

import be.thomasmore.qrace.model.AppUser;
import be.thomasmore.qrace.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("appUserRepository")
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {
    AppUser findByUsername(String username);

    @Query("SELECT u FROM AppUser u WHERE u.role = :role ORDER BY u.id ASC")
    AppUser findByRole(@Param("role") Role role);

    @Query("SELECT u FROM AppUser u WHERE u.role = :role ORDER BY u.id ASC")
    List<AppUser> findByRoleList(@Param("role") Role role);



    @Query("SELECT u FROM AppUser u WHERE u.role = :role AND u.username = :username")
    AppUser findByRoleAndUsername(@Param("role") Role role, @Param("username") String username);

    @Query("SELECT u FROM AppUser u WHERE u.role = :role AND u.username = :username")

    List<AppUser> findByRoleAndUsernameList(@Param("role") Role role, @Param("username") String username);

    @Query("SELECT u FROM AppUser u WHERE u.role = :role AND u.username = :username")

    AppUser findByEmail(String email);

    AppUser findByPasswordResetKey(String passwordResetKey);

    List<AppUser> findbyusername(String username);

}