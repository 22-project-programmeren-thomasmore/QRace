package be.thomasmore.qrace.service;

import be.thomasmore.qrace.model.Users;
import be.thomasmore.qrace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(Users users) {
        userRepository.save(users);
    }

    // other methods
}
