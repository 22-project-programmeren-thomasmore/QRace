package be.thomasmore.qrace.controller;


import be.thomasmore.qrace.model.Users;
import be.thomasmore.qrace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Optional;


@Controller
public class VisitorController {
    //    @Autowired
//    private PasswordEncoder encoder;
    @Autowired
    private UserRepository userRepository;

    @GetMapping({"", "/", "/visitorIndex"})
    public String visitorIndex() {

        return "visitorIndex";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam String username, @RequestParam String password) {
        return switch (userRepository.findByUSERNAME(username).get().getRole()) {
            case "ROLE_ADMIN" -> "redirect:/admin";
            case "ROLE_USER" -> "redirect:/user";
            default -> "visitorpagina";
        };
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registerPost(Principal principal,
                               Model model,
                               @RequestParam String username,
                               @RequestParam String password) {
        if (principal != null
                || username == null || username.trim().equals("")
                || password == null || password.trim().equals(""))
            return "redirect:/";
        Optional<Users> optionalUser = userRepository.findByUSERNAME(username.trim());

        String errorMessage;
        if (optionalUser.isPresent())
            errorMessage = "Deze gebruikersnaam bestaat al!";

        else {
            Users users = new Users(username, password, "ROLE_USER");
            userRepository.save(users);
            return "redirect:/users";
        }
        model.addAttribute("error", errorMessage);
        model.addAttribute("username", username);
        return "registration";
    }
}


