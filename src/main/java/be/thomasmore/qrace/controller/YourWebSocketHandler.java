package be.thomasmore.qrace.controller;

import be.thomasmore.qrace.model.RaceStatusEnum;
import be.thomasmore.qrace.model.RaceUpdate;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class YourWebSocketHandler extends TextWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // Handle the connection establishment, e.g., add the session to the list of active sessions
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Handle the received message, e.g., parse the message and process the game action
        String payload = message.getPayload();
        // Process the game action and generate the corresponding game updates
        RaceUpdate raceUpdate = processGameAction(payload);

        // Convert the raceUpdate to JSON or any desired format
        String raceUpdateJson = convertToJson(raceUpdate);

        // Send the raceUpdate to the participants
        session.sendMessage(new TextMessage(raceUpdateJson));
    }

    private String convertToJson(RaceUpdate raceUpdate) {
        return null;
    }

    private RaceUpdate processGameAction(String payload) {
        return null;
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // Handle the connection closure, e.g., remove the session from the list of active sessions
    }
}



