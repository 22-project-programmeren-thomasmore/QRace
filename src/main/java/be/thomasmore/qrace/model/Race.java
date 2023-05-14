package be.thomasmore.qrace.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder // Lombok
public class Race {

    @Id
    private String id;
    private Player firstPlayer;
    private Player secondPlayer;
    private Player thirdPlayer;
    private Player fourthPlayer;
    private Player winner;
}
