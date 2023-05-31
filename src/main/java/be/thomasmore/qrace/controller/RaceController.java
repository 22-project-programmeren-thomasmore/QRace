package be.thomasmore.qrace.controller;

import be.thomasmore.qrace.model.Race;
import be.thomasmore.qrace.repository.RaceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class RaceController {
    private final RaceRepository raceRepository;

    public RaceController(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @GetMapping("/race")
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
}
