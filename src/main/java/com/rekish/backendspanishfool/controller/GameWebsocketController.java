package com.rekish.backendspanishfool.controller;

import com.rekish.backendspanishfool.model.dto.messaging.MoveDto;
import com.rekish.backendspanishfool.model.dto.messaging.MoveResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@AllArgsConstructor

@Controller
public class GameWebsocketController {

    @MessageMapping("/in/move/{sessionId}")
    @SendTo("/out/move/{sessionId}")
    public MoveResponseDto processMove(@DestinationVariable("sessionId") Long sessionId, MoveDto moveDto) {
        return new MoveResponseDto(moveDto.getOwner(), moveDto.getType(), moveDto.getPayload(), 0, true, false, false);
    }
}
