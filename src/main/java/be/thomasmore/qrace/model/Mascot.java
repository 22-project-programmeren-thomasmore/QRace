package be.thomasmore.qrace.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
@Builder
// de mascottes zijn de verschillende characters binnen QRace
public class Mascot {
    @Id
    private String MascotID;

    private String name;
    private String image;
    private String description;

    public Mascot() {

    }
}