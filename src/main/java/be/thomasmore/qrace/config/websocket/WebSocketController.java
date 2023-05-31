package be.thomasmore.qrace.config.websocket;

import be.thomasmore.qrace.config.model.RaceAction;
import be.thomasmore.qrace.model.Race;
import be.thomasmore.qrace.model.RaceUpdate;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WebSocketController {
    private Map<String, WebSocketSession> playerSessions = new HashMap<>();

    private WebSocketSession getPlayerSession(String sessionId) {
        return playerSessions.get(sessionId);
    }

    private void sendGameUpdateToUser(WebSocketSession userSession, RaceUpdate raceUpdate) {
        try {
            if (userSession.isOpen()) {
                userSession.sendMessage(new TextMessage(raceUpdate.toJson()));
            }
        } catch (IOException e) {
            // Handle the exception
        }
    }

    @MessageMapping("/game/{sessionId}")
    public void handleGameAction(@DestinationVariable String sessionId, RaceAction raceAction) {
        RaceUpdate raceUpdate = new RaceUpdate();
        // Populate other properties of the raceUpdate object based on your game logic

        // Retrieve the specific user's WebSocket session based on the session ID
        WebSocketSession userSession = getPlayerSession(sessionId);

        // Send the game update to the specific user
        sendGameUpdateToUser(userSession, raceUpdate);
    }

}
