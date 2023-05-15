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
    private Integer galleryID;
    private String name;
    private String description;
    private String qrCode;

    public Gallery (Integer galleryID) {
        this.galleryID = galleryID;
    }

    public Gallery(Integer galleryID,String name, String description, String qrCode) {
        this.galleryID = galleryID;
        this.name = name;
        this.description = description;
        this.qrCode = qrCode;
    }

    public Integer getGalleryID() {
        return galleryID;
    }

    public void setGalleryID(int galleryID) {
        this.galleryID = galleryID;
    }

    public static void setGalleries() {
        ArrayList<Gallery> galleries = new ArrayList<>();
        galleries.add(new Gallery(1, "Dolls", "Gallery 1 description", "www.google.com"));
        galleries.add(new Gallery(2, "Playmobil", "Gallery 2 description", "www.google.com"));
        galleries.add(new Gallery(3, "Mechanical toys, robots and space", "Gallery 3 description", "www.google.com"));
        galleries.add(new Gallery(4, "Fun fair and circus", "Gallery 4 description", "www.google.com"));
        galleries.add(new Gallery(5, "Constructive toys", "Gallery 5 description", "www.google.com"));
        galleries.add(new Gallery(6, "Teddy bears and stuffed animals", "Gallery 6 description", "www.google.com"));
        galleries.add(new Gallery(7, "Trains", "Gallery 7 description", "www.google.com"));
        galleries.add(new Gallery(8, "Board games", "Gallery 8 description", "www.google.com"));
        galleries.add(new Gallery(9, "Traditional children's games: Breughel's children's games", "Gallery 9 description", "www.google.com"));
        galleries.add(new Gallery(10, "International toys", "Gallery 10 description", "www.google.com"));
        galleries.add(new Gallery(11, "Temporary exhibition", "Gallery 11 description", "www.google.com"));
    }
}