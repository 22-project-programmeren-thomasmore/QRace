package be.thomasmore.qrace.controller;

import be.thomasmore.qrace.dto.JoinRequest;
import be.thomasmore.qrace.exception.RaceException;
import be.thomasmore.qrace.model.Player;
import be.thomasmore.qrace.model.Race;
import be.thomasmore.qrace.service.RaceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/lobby")
public class LobbyController {
    private final RaceService raceService;

    @GetMapping({"/", "/lobby"})
    public String lobby() {
        return "name";
    }

    @GetMapping("/host-join")
    public String hostJoinPage() {
        return "host-join";
    }

    @PostMapping("/host")
    public ResponseEntity<Race> host(@RequestBody Player hostPlayer) {
        log.info("host game request: {}", hostPlayer);
        return ResponseEntity.ok(raceService.createNewRace(hostPlayer));
    }

    @PostMapping("/join/{raceID}")
    public ResponseEntity<Race> join(@RequestBody JoinRequest request) throws RaceException {
        log.info("connect request: {}", request);
        return ResponseEntity.ok(raceService.connectToRace(request.getPlayer(), request.getRaceID()));
    }
}
