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
        int randomPlayerID = new Random().nextInt(9000) + 1000;
        String sql = "INSERT INTO RACES values (" + randomPlayerID + ", 1, 2, 3, 4)";
        entityManager.createNativeQuery(sql).executeUpdate();
        return randomPlayerID;
    }
    @Transactional
    public Race createNewRace (Player player1) {
        Race race = new Race(generateRaceID());
        races.put(Integer.toString(race.getRaceID()), race);
        race.setStatus(RaceStatusEnum.NEW);
        return race;
    }

    public Race connectToRace (Player player, Integer raceID) {
        Optional<Race> optionalRace = raceRepository.findById(raceID);
        optionalRace.orElseThrow(() -> new RaceException("Race with provided ID doesn't exist"));
        Race race = optionalRace.get();
        if (race.getPlayer4() != null) {
            throw new RaceException("Race is not valid anymore");
        }
        else if (race.getPlayer1() != null) {
            race.setPlayer2(player);
        }
        else if (race.getPlayer2() != null) {
            race.setPlayer3(player);
        }
        else if (race.getPlayer3() != null) {
            race.setPlayer4(player);
        }
        return race;
    }

}