package be.thomasmore.qrace.config.websocket;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WebSocketController {
    private Map<String, WebSocketSession> playerSessions = new HashMap<>();

    private void sendGameUpdateToUser(WebSocketSession userSession, RaceUpdate raceUpdate) {
        try {
            if (userSession != null && userSession.isOpen()) {
                userSession.sendMessage(new TextMessage(raceUpdate.toJson()));
            }
        } catch (IOException e) {
            // Handle the exception
        }
    }

    @MessageMapping("/game/{sessionId}")
    public void handleGameAction(@DestinationVariable String sessionId, RaceAction raceAction) {
        RaceUpdate raceUpdate = new RaceUpdate();
        raceUpdate.setRaceID(raceAction.getRaceId());
        // Set other properties of the RaceUpdate as needed

        // Retrieve the specific user's WebSocket session based on the session ID
        WebSocketSession userSession = playerSessions.get(sessionId);

        // Send the game update to the specific user
        sendGameUpdateToUser(userSession, raceUpdate);
    }
}
