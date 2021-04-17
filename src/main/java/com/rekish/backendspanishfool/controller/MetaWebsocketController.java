package com.rekish.backendspanishfool.controller;

import com.rekish.backendspanishfool.model.dto.messaging.meta.MetaMessageDto;
import com.rekish.backendspanishfool.model.dto.messaging.meta.PlayerStatusChanging;
import com.rekish.backendspanishfool.model.dto.model.PlayerDto;
import lombok.AllArgsConstructor;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@AllArgsConstructor
@Controller
@CrossOrigin("*")
public class MetaWebsocketController {
    private final MessageSendingOperations<String> messageSender;

    @MessageMapping("/in/meta/{sessionId}")
    public void playerLeft(@DestinationVariable("sessionId") Long sessionId, PlayerDto playerDto) {
        MetaMessageDto metaMessageDto = new MetaMessageDto(PlayerStatusChanging.LEAVE, playerDto.getUid());
        sendMetaMessage(metaMessageDto, sessionId);

    }

    public void playerJoined(Long sessionId, PlayerDto playerDto) {
        MetaMessageDto metaMessage = new MetaMessageDto(PlayerStatusChanging.JOIN, playerDto.getUid());
        sendMetaMessage(metaMessage, sessionId);
    }

    private void sendMetaMessage(MetaMessageDto metaMessageDto, Long sessionId) {
        messageSender.convertAndSend("/out/meta/" + sessionId, metaMessageDto);
    }

}
