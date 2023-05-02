package be.thomasmore.qrace.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HostJoinController {

    @GetMapping("/host-join")
    public String hostJoinPage() {
        return "host-join";
    }
}
