package be.thomasmore.qrace.controller;

import be.thomasmore.qrace.model.User;
import be.thomasmore.qrace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/Users")
    public String listAll(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listStudents", listUsers);

        return "users";
    }

}
