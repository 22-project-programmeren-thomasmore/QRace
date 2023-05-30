package be.thomasmore.qrace.B_registration;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {

    private final  String username;
    private final  String password;
    private final  String email;

}
