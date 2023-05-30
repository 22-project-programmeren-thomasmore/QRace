package be.thomasmore.qrace.dto;

import be.thomasmore.qrace.model.Player;
import lombok.Data;

@Data
public class JoinRequest {
    private Player player;
    private String raceID;
}

