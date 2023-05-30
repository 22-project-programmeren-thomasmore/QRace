package be.thomasmore.qrace.model;

import jakarta.persistence.*;
//import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.management.relation.Role;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.List;

@Entity
//@MappedSuperclass
public class AppUser implements UserDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String email;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Integer age;
    private String phone;
    private String address;
    private String city;
    private String postalCode;
    private String country;
    private String speciality;
    private Role role;


    private String passwordResetKey;


    @Column(length = 5000)

//    @Column(columnDefinition = "varchar(5000) default 'https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png\n' ")
    private String imageUrl;


    @Column(length = 5000)

    private String shortDescription;


    private String job;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "doctor", cascade = CascadeType.REMOVE)
    private Collection<Appointment> appointments;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "client", cascade = CascadeType.REMOVE)
    private Collection<Appointment> clientAppointments;

//
//    @OneToMany(fetch = FetchType.EAGER,mappedBy = "client")
//    private Collection<Toy> toys;


    @Override
    public String getUsername() {
        // Return the username or identifier for the user
        return username;
    }


    // Constructors
    public AppUser() {

    }

    public Collection<Appointment> getClientAppointments() {
        return clientAppointments;
    }

    public void setClientAppointments(Collection<Appointment> clientAppointments) {
        this.clientAppointments = clientAppointments;
    }

    public AppUser(String username, String password, String firstName, String lastName, Role role) {
    }

    public AppUser(String firstName, String lastName, Role role) {
    }

    public AppUser(String firstName, String lastName, String email, String phone) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhone(phone);
        role = Role.USER;
    }


    public AppUser(String email, String username, String password, String firstName, String lastName, Integer age, String phone, String address, String city, String postalCode, String country, String speciality, Role role) {
        setEmail(email);
        setUsername(username);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setPhone(phone);
        setAddress(address);
        setCity(city);
        setPostalCode(postalCode);
        setCountry(country);
        setSpeciality(speciality);
        setRole(role);
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean isAccountNonExpired() {
        // Return true if the user's account is non-expired
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Return true if the user's account is non-locked
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Return true if the user's credentials are non-expired
        return true;
    }


    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public Collection<Appointment> getAppointments() {
        return this.appointments;
    }

    public void setAppointments(Collection<Appointment> appointments) {
        this.appointments = appointments;
    }

//    public Collection<Toy> getToys() {
//        return toys;
//    }
//
//    public void setToys(Collection<Toy> toys) {
//        this.toys = toys;
//    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public void generateSecretPasswordResetKey(String userId) {
        // Genereer een array van 16 bytes voor de secretkey
        byte[] keyBytes = new byte[16];
        new SecureRandom().nextBytes(keyBytes);

        // Combineer de secretkey met de bytes van de gebruikers-ID
        byte[] combinedBytes = new byte[keyBytes.length + userId.getBytes().length];
        System.arraycopy(userId.getBytes(), 0, combinedBytes, 0, userId.getBytes().length);
        System.arraycopy(keyBytes, 0, combinedBytes, userId.getBytes().length, keyBytes.length);

        // Encodeer de gecombineerde bytes naar een secretkey in Base64-formaat
        String secretKey = Base64.getUrlEncoder().withoutPadding().encodeToString(combinedBytes);

        // Wijs de secretkey toe aan het huidige object
        this.passwordResetKey = secretKey;
    }

    public String getPasswordResetKey() {
        return passwordResetKey;
    }


    public void removePasswordResetKey() {
        passwordResetKey = null;
    }


    public List<Role> getRoles() {
        return Arrays.asList(Role.values());
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}


