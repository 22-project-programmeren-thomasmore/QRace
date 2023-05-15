package be.thomasmore.qrace.model;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

@Data
@Builder
// de galleries zijn de verschillende afdelingen van het museum
public class Gallery {
    @Id
    private String id;
    private String name;
    private String description;
    private String image;

    public Gallery(String id, String name, String description, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public static void setGalleries() {
        ArrayList<Gallery> galleries = new ArrayList<Gallery>();
        galleries.add(new Gallery("01", "Dolls", "Gallery 1 description", "www.google.com"));
        galleries.add(new Gallery("02", "Playmobil", "Gallery 2 description", "www.google.com"));
        galleries.add(new Gallery("03", "Mechanical toys, robots and space", "Gallery 3 description", "www.google.com"));
        galleries.add(new Gallery("04", "Fun fair and circus", "Gallery 4 description", "www.google.com"));
        galleries.add(new Gallery("05", "Constructive toys", "Gallery 5 description", "www.google.com"));
        galleries.add(new Gallery("06", "Teddy bears and stuffed animals", "Gallery 6 description", "www.google.com"));
        galleries.add(new Gallery("07", "Trains", "Gallery 7 description", "www.google.com"));
        galleries.add(new Gallery("08", "Board games", "Gallery 8 description", "www.google.com"));
        galleries.add(new Gallery("09", "Traditional children's games: Breughel's children's games", "Gallery 9 description", "www.google.com"));
        galleries.add(new Gallery("10", "International toys", "Gallery 10 description", "www.google.com"));
        galleries.add(new Gallery("11", "Temporary exhibition", "Gallery 11 description", "www.google.com"));
    }
}