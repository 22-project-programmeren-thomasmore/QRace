package be.thomasmore.qrace.config.websocket;

import be.thomasmore.qrace.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RaceUpdate {
        private int raceID;
        private RaceStatusEnum status;
        // Other properties of RaceUpdate

        public RaceUpdate() {
        }

        // Getters and setters for raceId, status, and other properties

    public String toJson() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
