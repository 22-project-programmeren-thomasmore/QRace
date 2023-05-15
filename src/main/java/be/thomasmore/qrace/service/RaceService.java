package be.thomasmore.qrace.service;

import be.thomasmore.qrace.exception.RaceException;
import be.thomasmore.qrace.model.Player;
import be.thomasmore.qrace.model.Race;
import be.thomasmore.qrace.model.RaceStatusEnum;
import be.thomasmore.qrace.repository.RaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class RaceService {
    private final RaceRepository raceRepository;

    private String generateRaceID() {
        return String.format("%04d", new Random().nextInt(10000));
    }

    public Race createNewRace (Player hostPlayer) {
        Race newRace = new Race(hostPlayer);
        newRace.setRaceID(generateRaceID());
        newRace.setHostPlayer(hostPlayer);
        newRace.setStatus(RaceStatusEnum.NEW);
        raceRepository.save(newRace);
        return newRace;
    }

    public Race connectToRace (Player player, String raceID) {
        Optional<Race> optionalRace = raceRepository.findById(raceID);
        optionalRace.orElseThrow(() -> new RaceException("Race with provided ID doesn't exist"));
        Race race = optionalRace.get();
        if (race.getFourthPlayer() != null) {
            throw new RaceException("Race is not valid anymore");
        }
        race.setSecondPlayer(player);
        race.setStatus(RaceStatusEnum.IN_PROGRESS);
        raceRepository.save(race);
        return race;
    }
}