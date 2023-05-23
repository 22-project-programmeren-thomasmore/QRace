package be.thomasmore.qrace.controller;

import be.thomasmore.qrace.dto.JoinRequest;
import be.thomasmore.qrace.exception.RaceException;
import be.thomasmore.qrace.model.Player;
import be.thomasmore.qrace.model.Race;
import be.thomasmore.qrace.service.RaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@SessionAttributes("name")
public class LobbyController{
    private RaceService raceService;

    @ModelAttribute("name")
    public String name() {
        return "";
    }
    @GetMapping({ "/name" })
    public String giveName() {
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

    @PostMapping("/host")
    public ResponseEntity<Race> host(@RequestBody Player hostPlayer) {
        log.info("host game request: {}", hostPlayer);
        return ResponseEntity.ok(raceService.createNewRace(hostPlayer));
    }

    @GetMapping({ "/join"})
    public String seeAvailableRaces() {
        return "join-availableRaces";
    }

    @PostMapping("/join")
    public ResponseEntity<Race> join(@RequestBody JoinRequest request)
            throws RaceException {
        log.info("connect request: {}", request);
        return ResponseEntity.ok(
                raceService.connectToRace(request.getPlayer(), request.getRaceID())
        );
    }

    @GetMapping({ "/join/pickMascot" })
    public String pickMascotAsMember() {
        return "join-pickMascot";
    }

    @GetMapping({ "/lobby" })
    public String lobby() {
        return "lobby";
    }
}
