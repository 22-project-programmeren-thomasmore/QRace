package be.thomasmore.qrace.service;

import be.thomasmore.qrace.controllers.UsersRepository;
import be.thomasmore.qrace.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UsersRepository userRepository;

    @Autowired
    public UserService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    // other methods
}
