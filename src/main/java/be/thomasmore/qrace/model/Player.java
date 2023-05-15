package be.thomasmore.qrace.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Player {
    @Id
    private String id;
    private String name;
    private Mascot chosenMascot;
    private int position;
    private int score;
}