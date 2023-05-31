package be.thomasmore.qrace.model;

import be.thomasmore.qrace.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RaceUpdate {
        private int raceId;
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
