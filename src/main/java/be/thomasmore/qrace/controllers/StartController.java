package be.thomasmore.qrace.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {

  @GetMapping("/")
  public String showStartPage() {
    return "start";
  }
}
