package be.thomasmore.qrace.service;

import be.thomasmore.qrace.exception.RaceException;
import be.thomasmore.qrace.model.*;
import be.thomasmore.qrace.model.RaceStatusEnum;
import be.thomasmore.qrace.repository.RaceRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
@AllArgsConstructor
public class RaceService {
    private final Map<String, Race> races = new ConcurrentHashMap<>();
    private RaceRepository raceRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public int generateRaceID() {
        int randomRaceID = new Random().nextInt(9000) + 1000;
        String sql = "INSERT INTO RACES values (" + randomRaceID + ", 1, 2, 3, 4)";
        entityManager.createNativeQuery(sql).executeUpdate();
        return randomRaceID;
    }

    public Race createRace(int raceID, Player host) {
        Race race = new Race(generateRaceID(), host);
        races.put(Integer.toString(race.getRaceID()), race);
        race.setStatus(RaceStatusEnum.NEW);
        raceRepository.save(race);
        return race;
    }

    public Race joinRace(int raceID, Player participant) {
        Race race = raceRepository.findById(raceID).orElse(null);
        if (race != null) {
            race.addParticipant(participant);
            return raceRepository.save(race);
        }
        return null; // add throw exception indicating session not found
    }
    public Race findRaceById(int raceID) {
        Optional<Race> optionalRace = raceRepository.findById(raceID);

        if (optionalRace.isPresent()) {
            return optionalRace.get();
        } else {
            throw new IllegalArgumentException("Race with ID " + raceID + " not found");
        }
    }
}