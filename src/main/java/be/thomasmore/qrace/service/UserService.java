package be.thomasmore.qrace.service;

import be.thomasmore.qrace.model.User;
import be.thomasmore.qrace.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    // other methods
}
