package be.thomasmore.team_5.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("/next")
    public ModelAndView next() {
        ModelAndView modelAndView = new ModelAndView("next");
        return modelAndView;
    }
}
