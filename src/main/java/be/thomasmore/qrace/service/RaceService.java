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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    public int generatePlayerID() {
        int randomPlayerID = new Random().nextInt(9000) + 1000;
        String sql = "INSERT INTO PLAYERS values (" + randomPlayerID + ", 1, 2, 3, 4)";
        entityManager.createNativeQuery(sql).executeUpdate();
        return randomPlayerID;
    }
    public int generateRaceID() {
        int randomRaceID = new Random().nextInt(9000) + 1000;
        String sql = "INSERT INTO RACES values (" + randomRaceID + ", 1, 2, 3, 4)";
        entityManager.createNativeQuery(sql).executeUpdate();
        return randomRaceID;
    }

    public Race createRace(int raceID, Player host) {
        Race race = new Race(generateRaceID(), host);
        return raceRepository.save(race);
    }

    public Race race(int raceID, Player participant) {
        Race race = raceRepository.findById(raceID).orElse(null);
        if (race != null) {
            race.addParticipant(participant);
            return raceRepository.save(race);
        }
        return null; // add throw exception indicating session not found
    }

    public List<Question> getRaceQuestions(int raceID) {
        Race race = raceRepository.findById(raceID).orElse(null);
        if (race != null) {
            return race.getQuestions();
        }
        return null; // or throw an exception indicating session not found
    }

    public int calculateScore(Race race, long elapsedTime) {
        // calculate score based on correct answers and elapsed time
        int correctAnswers = race.getQuestions().size();
        double timeInSeconds = elapsedTime / 1000.0; // Convert elapsed time to seconds
        double score = (correctAnswers * 100) - (timeInSeconds * 10);
        return (int) Math.max(score, 0);
    }
}