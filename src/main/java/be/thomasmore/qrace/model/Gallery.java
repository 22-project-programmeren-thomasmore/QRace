package be.thomasmore.qrace.model;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Gallery {
    @Id
    private Integer galleryID;
    private String name;

    public Gallery(Integer galleryID,String name) {
        this.galleryID = galleryID;
        this.name = name;
    }

    public static void setGalleries() {
        ArrayList<Gallery> galleries = new ArrayList<>();
        galleries.add(new Gallery(1, "Dolls"));
        galleries.add(new Gallery(2, "Playmobil"));
        galleries.add(new Gallery(3, "Mechanical toys, robots and space"));
        galleries.add(new Gallery(4, "Fun fair and circus"));
        galleries.add(new Gallery(5, "Constructive toys"));
        galleries.add(new Gallery(6, "Teddy bears and stuffed animals"));
        galleries.add(new Gallery(7, "Trains"));
        galleries.add(new Gallery(8, "Board games"));
        galleries.add(new Gallery(9, "Traditional children's games: Breughel's children's games"));
        galleries.add(new Gallery(10, "International toys"));
    }
}