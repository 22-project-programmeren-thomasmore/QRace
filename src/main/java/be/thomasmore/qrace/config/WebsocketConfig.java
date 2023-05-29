package be.thomasmore.qrace.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Here, "/ws" is the WebSocket endpoint that the client will use to connect to the server
        registry.addEndpoint("/race").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // "/app" is the prefix for messages that are bound for @MessageMapping methods in @Controller classes
        registry.setApplicationDestinationPrefixes("/app");

        // "/topic" is the prefix used for topic destinations (i.e., destinations that multiple subscribers can subscribe to)
        // "/queue" is the prefix used for queue destinations (i.e., destinations that only one subscriber can subscribe to)
        registry.enableSimpleBroker("/topic", "/queue");
    }
}