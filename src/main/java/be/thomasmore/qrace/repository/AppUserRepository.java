package be.thomasmore.qrace.repository;

import be.thomasmore.qrace.model.AppUser;
import be.thomasmore.qrace.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("appUserRepository")
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {
    AppUser findByUsername(String username);
//    @Query("SELECT u.role FROM AppUser u ORDER BY u.id ASC WHERE u.role = ?1")
//    Iterable<AppUser> findByRole(Role role);


    @Query("SELECT u FROM AppUser u WHERE u.role = :role ORDER BY u.id ASC")
    AppUser findByRole(@Param("role") Role role);

    @Query("SELECT u FROM AppUser u WHERE u.role = :role ORDER BY u.id ASC")
    List<AppUser> findByRoleList(@Param("role") Role role);

    @Query("SELECT u FROM AppUser u " +
            "WHERE ?1 IS NULL OR LOWER (u.firstName) LIKE LOWER(CONCAT('%',?1,'%'))" +
            "AND  (?2 IS NULL OR u.role = ?2)" +
            "AND (?3 IS NULL OR u.speciality = ?3)"
    )
    List<AppUser> findByDoctorWithFilter(String keyword,Role role,String speciality);



    @Query("SELECT u FROM AppUser u WHERE u.role = :role AND u.username = :username")
    AppUser findByRoleAndUsername(@Param("role") Role role, @Param("username") String username);

    Optional<AppUser> findFirstByIdLessThanOrderByIdDesc(Integer id);

    Optional<AppUser> findFirstByIdGreaterThanOrderById(Integer id);

    Optional<AppUser> findFirstByOrderByIdDesc();

    Optional<AppUser> findFirstByOrderByIdAsc();

    AppUser findByEmail(String email);

    AppUser findByPasswordResetKey(String passwordResetKey);

    List<AppUser> findbyusername(String firstName);


}