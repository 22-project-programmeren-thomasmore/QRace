package be.thomasmore.team_5.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConnectController {

    @GetMapping("/join")
    public ModelAndView join() {
        ModelAndView modelAndView = new ModelAndView("join");
        return modelAndView;
    }

    @GetMapping("/host")
    public ModelAndView host() {
        ModelAndView modelAndView = new ModelAndView("host");
        return modelAndView;
    }
}
