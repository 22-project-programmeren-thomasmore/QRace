package be.thomasmore.qrace.controllers;

import be.thomasmore.qrace.model.Player;
import be.thomasmore.qrace.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class NameController {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/name")
    public String showNameForm() {
        return "name";
    }

    @PostMapping("/name")
    public ModelAndView handleNameSubmit(@RequestParam("name") String name) {
        Player player = playerRepository.savePlayerWithName(name);
        ModelAndView modelAndView = new ModelAndView("host-join");
        modelAndView.addObject("name", player.getName());
        modelAndView.addObject("playerID", player.getPlayerId());
        return modelAndView;
    }
}


