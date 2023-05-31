package be.thomasmore.qrace.controller;
import be.thomasmore.qrace.model.Player;
import be.thomasmore.qrace.model.Race;
import be.thomasmore.qrace.repository.RaceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/race")
public class RaceController {
    private final RaceRepository raceRepository;

    public RaceController(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    private Player getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof Player) {
            return (Player) authentication.getPrincipal();
        }
        // Return null or handle the case when the current user is not available
        return null;
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
    public ResponseEntity<Race> joinRace(@PathVariable int raceID) {
        Optional<Race> optionalRace = raceRepository.findById(raceID);

        if (optionalRace.isEmpty()) {
            // Race not found, return 404 Not Found status
            return ResponseEntity.notFound().build();
        }

        Race race = optionalRace.get();

        // Perform any necessary logic to join the race
        // For example, add the current user to the race participants
        Player currentUser = getCurrentUser(); // Replace with your logic to get the current user
        race.addParticipant(currentUser);

        // Save the updated race in the repository
        raceRepository.save(race);

        // Return the updated race with a 200 OK status
        return ResponseEntity.ok(race);
    }

}
