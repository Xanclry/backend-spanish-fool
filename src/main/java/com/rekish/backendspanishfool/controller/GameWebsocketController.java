package com.rekish.backendspanishfool.controller;

import lombok.AllArgsConstructor;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@AllArgsConstructor

@Controller
public class GameWebsocketController {
    private final MessageSendingOperations<String> stringSender;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/in/{sessionId}")
    @SendTo("/out/{sessionId}")
    public String processMove(@DestinationVariable("sessionId") Long sessionId, String message) {
        return "Hello! " + sessionId + " " + message;
    }
}
