package be.thomasmore.qrace.service;

import be.thomasmore.qrace.model.Player;
import be.thomasmore.qrace.model.Race;
import be.thomasmore.qrace.model.RaceStatusEnum;
import be.thomasmore.qrace.repository.RaceRepository;
import org.apache.commons.lang3.time.StopWatch;

import java.util.Optional;

public class PlayerService {
    private RaceRepository raceRepository;

    public Race startRace (Player player1, Integer raceID) {
        Optional<Race> optionalRace = raceRepository.findById(raceID);
        Race race = optionalRace.get();
        race.setStatus(RaceStatusEnum.IN_PROGRESS);
        raceRepository.save(race);
        return race;
    }

    public Race endRace (Player host, Integer raceID) {
        Optional<Race> optionalRace = raceRepository.findById(raceID);
        Race race = optionalRace.get();
        race.setStatus(RaceStatusEnum.FINISHED);
        return race;
    }

    public void startSession() {
    }

    public void stopSession() {
    }

    public void startStopWatch() {
        StopWatch watch = new StopWatch();
        watch.start();
    }

    public void stopStopWatch() {
        StopWatch watch = new StopWatch();
        watch.stop();
        System.out.println(watch.getTime());
    }

}
