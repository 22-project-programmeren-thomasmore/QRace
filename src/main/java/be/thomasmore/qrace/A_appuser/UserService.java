package be.thomasmore.qrace.A_appuser;

import be.thomasmore.qrace.model.User;
import be.thomasmore.qrace.A_appuser.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*public void saveUser(User user) {
        userRepository.save(user);
    }*/

    // other methods
}
