package be.thomasmore.qrace.controller;

import java.util.List;

import be.thomasmore.qrace.model.Users;
import be.thomasmore.qrace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/Users")
    public String users(Model model) {
        List<Users> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "users";
    }
}
