//package be.thomasmore.qrace.model;
//
//import jakarta.persistence.*;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import javax.management.relation.Role;
//import java.security.SecureRandom;
//import java.util.Arrays;
//import java.util.Base64;
//import java.util.Collection;
//import java.util.List;
//
//@Entity
////@MappedSuperclass
//public class AppUser implements UserDetails {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    private Integer id;
//    private String username;
//    private String passwoord;
//    private Role role;
//
//    private String passwordResetKey;
//
//    @Override
//    public String getUsername() {
//        // Return the username or identifier for the user
//        return username;
//    }
//
//
//    // Constructors
//    public AppUser() {
//
//    }
//
//
//    public AppUser(String username, String passwoord) {
//        setUsername(username);
//        setPasswoord(passwoord);
//
//    }
//
//
//    public AppUser(String email, String username, String passwoord, Role role) {
//        setUsername(username);
//        setPasswoord(passwoord);
//        setRole(role);
//    }
//
//    // Getters and Setters
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//
//
//
//
//
//    @Override
//    public boolean isAccountNonExpired() {
//        // Return true if the user's account is non-expired
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        // Return true if the user's account is non-locked
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        // Return true if the user's credentials are non-expired
//        return true;
//    }
//
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    public String getPasswoord() {
//        return passwoord;
//    }
//
//    public void setPasswoord(String password) {
//        this.passwoord = password;
//    }
//
//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }
//
//    public void generateSecretPasswordResetKey(String userId) {
//        // Genereer een array van 16 bytes voor de secretkey
//        byte[] keyBytes = new byte[16];
//        new SecureRandom().nextBytes(keyBytes);
//
//        // Combineer de secretkey met de bytes van de gebruikers-ID
//        byte[] combinedBytes = new byte[keyBytes.length + userId.getBytes().length];
//        System.arraycopy(userId.getBytes(), 0, combinedBytes, 0, userId.getBytes().length);
//        System.arraycopy(keyBytes, 0, combinedBytes, userId.getBytes().length, keyBytes.length);
//
//        // Encode the bytes to a secretkey in a Base64-format String
//        String secretKey = Base64.getUrlEncoder().withoutPadding().encodeToString(combinedBytes);
//
//        // ridirect the current user to the password reset page
//        this.passwordResetKey = secretKey;
//    }
//
//    public String getPasswordResetKey() {
//        return passwordResetKey;
//    }
//
//
//    public void removePasswordResetKey() {
//        passwordResetKey = null;
//    }
//
//
//    public List<Role> getRoles() {
//        return Arrays.asList(role);
//    }
//
//}
//
//
