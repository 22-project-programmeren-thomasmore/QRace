package be.thomasmore.qrace.controllers;

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
        ModelAndView modelAndView = new ModelAndView("host-join");
        modelAndView.addObject("name", name);
        return modelAndView;
    }
}
