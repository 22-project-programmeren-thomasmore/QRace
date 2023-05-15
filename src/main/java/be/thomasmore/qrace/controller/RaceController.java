package be.thomasmore.qrace.controller;

import be.thomasmore.qrace.dto.JoinRequest;
import be.thomasmore.qrace.exception.RaceException;
import be.thomasmore.qrace.model.Player;
import be.thomasmore.qrace.model.Race;
import be.thomasmore.qrace.service.RaceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/game")
public class RaceController {
    private final RaceService raceService;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/host")
    public ResponseEntity<Race> create(@RequestBody Player hostPlayer) {
        log.info("host game request: {}", hostPlayer);
        return ResponseEntity.ok(raceService.createNewRace(hostPlayer));
    }

    @PostMapping("/join")
    public ResponseEntity<Race> connect(@RequestBody JoinRequest request) throws RaceException {
        log.info("connect request: {}", request);
        return ResponseEntity.ok(raceService.connectToRace(request.getPlayer(), request.getRaceId()));
    }
}
