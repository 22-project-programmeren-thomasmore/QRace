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

    private void sendGameUpdateToUser(WebSocketSession userSession, RaceUpdate raceUpdate) throws IOException {
        if (userSession != null && userSession.isOpen()) {
            userSession.sendMessage(new TextMessage(raceUpdate.toJson()));
        } else {
            throw new IOException("User session is closed or null.");
        }
    }

    @MessageMapping("/game/{sessionId}")
    public void handleGameAction(@DestinationVariable String sessionId, RaceAction raceAction) {
        RaceUpdate raceUpdate = new RaceUpdate();
        raceUpdate.setRaceID(raceAction.getRaceId());
        // Set other properties of the RaceUpdate as needed

        // Retrieve the specific user's WebSocket session based on the session ID
        WebSocketSession userSession = playerSessions.get(sessionId);

        try {
            // Send the game update to the specific user
            sendGameUpdateToUser(userSession, raceUpdate);
        } catch (IOException e) {
            // Handle the exception and return an error response to the client
            e.printStackTrace();
            // You can return an error response to the client or perform other error handling actions
        }
    }
}
