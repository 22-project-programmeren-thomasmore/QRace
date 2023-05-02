package be.thomasmore.team_5.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConnectController {

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @GetMapping("/host")
    public String host() {
        return "host";
    }
}
