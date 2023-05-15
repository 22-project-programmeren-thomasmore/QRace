package be.thomasmore.qrace.controllers;

import java.util.List;

import be.thomasmore.qrace.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UsersRepository userRepo;

    @GetMapping("/Users")
    public String listAll(Model model) {
        List<User> listUsers = userRepo.findAll();
        model.addAttribute("listStudents", listUsers);

        return "users";
    }

}
