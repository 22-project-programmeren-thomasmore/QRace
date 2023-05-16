package be.thomasmore.qrace.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
// de mascottes zijn de verschillende characters binnen QRace
public class Mascot {
    private String name;
    private String image;
    private String description;
}