package be.thomasmore.qrace.controller;
import be.thomasmore.qrace.model.Player;
import be.thomasmore.qrace.model.Race;
import be.thomasmore.qrace.repository.RaceRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@Controller
public class RaceController {
    private final RaceRepository raceRepository;

    public RaceController(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public String getCurrentUserName(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null) {
            Player player = (Player) session.getAttribute("currentUser");
            if (player != null) {
                return player.getName();
            }
        }
        return null;
    }

    public int getCurrentPlayerId(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null) {
            Player player = (Player) session.getAttribute("currentUser");
            if (player != null) {
                return player.getPlayerID();
            }
        }
        return 0;
    }

    @GetMapping
    public String racePage() {
        return "race";
    }

    @PostMapping
    public ResponseEntity<Race> createRace() {
        Race race = new Race();
        // Perform any necessary initialization for the race
        // For example, set initial values, generate a unique race ID, etc.

        // Save the race in the repository
        raceRepository.save(race);

        // Return the created race with a 201 Created status
        return ResponseEntity.status(HttpStatus.CREATED).body(race);
    }

    @PostMapping("/{raceID}/join")
    public ResponseEntity<Race> joinRace(@PathVariable int raceID, HttpServletRequest request) {
        Optional<Race> optionalRace = raceRepository.findById(raceID);

        if (optionalRace.isEmpty()) {
            // Race not found, return 404 Not Found status
            return ResponseEntity.notFound().build();
        }

        Race race = optionalRace.get();

        // Perform any necessary logic to join the race
        // For example, add the current user to the race participants
        String currentUserName = getCurrentUserName(request);
        int currentPlayerId = getCurrentPlayerId(request);

        if (currentUserName != null && currentPlayerId != 0) {
            Player currentUser = new Player(currentPlayerId, currentUserName);
            race.addParticipant(currentUser);
        }

        // Save the updated race in the repository
        raceRepository.save(race);

        // Return the updated race with a 200 OK status
        return ResponseEntity.ok(race);
    }
}
