package be.thomasmore.qrace.controller;

import be.thomasmore.qrace.service.RaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@SessionAttributes("name")
public class RaceController {
    private RaceService raceService;

    @GetMapping("/race")
    public String racePage() {
        return "race";
    }
}


