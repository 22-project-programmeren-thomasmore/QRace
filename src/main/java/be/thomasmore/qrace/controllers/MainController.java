package be.thomasmore.qrace.controllers;

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

  @GetMapping("/start")
  public ModelAndView start() {
    ModelAndView modelAndView = new ModelAndView("start");
    return modelAndView;
  }
  @GetMapping("/host")
public ModelAndView host() {
    ModelAndView modelAndView = new ModelAndView("host");
    return modelAndView;
}

@GetMapping("/join")
public ModelAndView join() {
    ModelAndView modelAndView = new ModelAndView("join");
    return modelAndView;
}

}
