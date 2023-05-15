package be.thomasmore.qrace.dto;

import be.thomasmore.qrace.model.Player;
import lombok.Data;

@Data
public class JoinRequest {
    private Player player; //zorg ervoor dat dit een 2de, 3de of 4de player is
    private String raceId;
}

