package be.thomasmore.qrace.controller;

import java.util.List;

import be.thomasmore.qrace.A_appuser.AppUsers;
import be.thomasmore.qrace.model.User;
import be.thomasmore.qrace.A_appuser.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping("/Users")
    public String listAll(Model model) {
        List<AppUsers> listUsers = userRepo.findAll();
        model.addAttribute("listusers", listUsers);

        return "users";
    }

}
