package be.thomasmore.qrace.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("userName")
public class NameController {

    @ModelAttribute("userName")
    public String userName() {
        return "";
    }

    @GetMapping("/name")
    public String showNameForm() {
        return "name";
    }

    @PostMapping("/name")
    public String handleNameSubmit(@RequestParam("name") String name, Model model) {
        model.addAttribute("userName", name);
        return "redirect:/host-join";
    }
}
