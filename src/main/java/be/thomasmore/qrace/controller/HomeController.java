package be.thomasmore.qrace.controller;

import be.thomasmore.qrace.dto.JoinRequest;
import be.thomasmore.qrace.exception.RaceException;
import be.thomasmore.qrace.model.Player;
import be.thomasmore.qrace.model.Race;
import be.thomasmore.qrace.service.RaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class HomeController {

  private RaceService raceService;

  public HomeController(RaceService raceService) {
    this.raceService = raceService;
  }

  @GetMapping("/")
  public String showStartPage() {
    return "index";
  }

  @GetMapping("/login")
  public String loginPage() {
    return "login";
  }

  @GetMapping({ "/lobby" })
  public String lobby() {
    return "name";
  }

  @GetMapping("/host-join")
  public String hostJoinPage() {
    return "host-join";
  }

  @GetMapping("/join")
  public String joinPage() {
    return "join";
  }

  @GetMapping("/host")
  public String hostPage() {
    return "host";
  }

  @PostMapping("/host")
  public ResponseEntity<Race> host(@RequestBody Player hostPlayer) {
    log.info("host game request: {}", hostPlayer);
    return ResponseEntity.ok(raceService.createNewRace(hostPlayer));
  }

  @PostMapping("/join/{raceID}")
  public ResponseEntity<Race> join(@RequestBody JoinRequest request)
    throws RaceException {
    log.info("connect request: {}", request);
    return ResponseEntity.ok(
      raceService.connectToRace(request.getPlayer(), request.getRaceID())
    );
  }

  @GetMapping("/race")
  public String racePage() {
    return "race";
  }
}
