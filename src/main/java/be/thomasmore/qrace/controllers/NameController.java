package be.thomasmore.qrace.controllers;

import be.thomasmore.qrace.model.Player;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NameController {

    @GetMapping("/name")
    public String showNameForm() {
        return "name";
    }

    @PostMapping("/name")
    public ModelAndView handleNameSubmit(@RequestParam("name") String name) {
        Player player = new Player();
        player.setName(name);
        // save the player object in the database or session as needed

        ModelAndView modelAndView = new ModelAndView("host-join");
        modelAndView.addObject("player", player);
        return modelAndView;
    }

}
