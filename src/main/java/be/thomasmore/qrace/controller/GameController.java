package be.thomasmore.qrace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GameController {

    @GetMapping("/game")
    public ModelAndView next() {
        ModelAndView modelAndView = new ModelAndView("game");
        return modelAndView;
    }

}