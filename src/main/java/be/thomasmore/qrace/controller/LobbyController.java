package be.thomasmore.qrace.controller;

import be.thomasmore.qrace.dto.*;
import be.thomasmore.qrace.exception.*;
import be.thomasmore.qrace.model.*;
import be.thomasmore.qrace.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@SessionAttributes("name")
public class LobbyController{
    private PlayerService playerService;
    private RaceService raceService;

    @ModelAttribute("name")
    public String attributeName() {
        return "";
    }
    @GetMapping({ "/name" })
    public String name() {
        return "name";
    }

    @PostMapping("/name")
    public String handleNameSubmit(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "redirect:/host-join";
    }
    @GetMapping({ "/host-join" })
    public String hostOrJoin() {
        return "host-join";
    }

    @GetMapping({ "/host" })
    public String pickMascotAsHost() {
        return "host-pickMascot";
    }

    @GetMapping({ "/join"})
    public String seeAvailableRaces() {
        return "join-availableRaces";
    }
    @GetMapping({ "/join-pickMascot" })
    public String joinPickMascot() {
        return "join-pickMascot";
    }

    @GetMapping({ "/lobby" })
    public String lobby() {
        return "lobby";
    }
}
