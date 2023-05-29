package be.thomasmore.qrace.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @Id
    private String name;

    public static void main(String[] args) {
        Location location1 = new Location("Dolls");
        Location location2 = new Location("Playmobil");
        Location location3 = new Location("Mechanical toys, robots and space");
        Location location4 = new Location("Fun fair and circus");
        Location location5 = new Location("Constructive toys");
        Location location6 = new Location("Teddy bears and stuffed animals");
        Location location7 = new Location("Trains");
        Location location8 = new Location("Board games");
        Location location9 = new Location("Traditional children's games: Breughel's children's games");
        Location location10 = new Location("International toys");

        ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(location1);
        locations.add(location2);
        locations.add(location3);
        locations.add(location4);
        locations.add(location5);
        locations.add(location6);
        locations.add(location7);
        locations.add(location8);
        locations.add(location9);
        locations.add(location10);

    }
}
