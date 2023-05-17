package be.thomasmore.qrace.repository;

import be.thomasmore.qrace.model.Race;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceRepository extends JpaRepository<Race, String> {
}