package com.rekish.backendspanishfool.controller;

import com.rekish.backendspanishfool.model.dto.model.GameSessionDto;
import com.rekish.backendspanishfool.model.dto.model.PlayerDto;
import com.rekish.backendspanishfool.model.dto.session.NewSessionDto;
import com.rekish.backendspanishfool.model.entity.session.GameSession;
import com.rekish.backendspanishfool.model.mapper.GameSessionMapper;
import com.rekish.backendspanishfool.service.session.GameSessionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/session")
@AllArgsConstructor
@CrossOrigin("*")
public class SessionController {

    private final GameSessionService gameSessionService;
    private final MetaWebsocketController metaWebsocketController;

    private final GameSessionMapper gameSessionMapper;

    @GetMapping("/open")
    public ResponseEntity<List<GameSessionDto>> getOpenGameSessions() {

        List<GameSession> openGameSessions = gameSessionService.getOpenGameSessions();
        List<GameSessionDto> gameSessionDtos = openGameSessions.stream()
                .map(gameSessionMapper::gameSessionToGameSessionDto)
                .peek(dto -> dto.setGameState(null)).collect(Collectors.toList());
        return ResponseEntity.ok(gameSessionDtos);
    }

    @GetMapping("/{sessionId}")
    public ResponseEntity<GameSessionDto> getGameSession(@PathVariable Long sessionId) {
        Optional<GameSession> optionalGameSession = gameSessionService.getByKey(sessionId);
        return optionalGameSession.map(gameSession -> ResponseEntity.ok(gameSessionMapper.gameSessionToGameSessionDto(gameSession))).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping
    public ResponseEntity<Long> createOpenGameSession(@RequestBody @Valid NewSessionDto newSessionDto) {
        GameSession createdGameSession = gameSessionService.createOpenGameSession(newSessionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdGameSession.getId());
    }

    @PostMapping("/{sessionId}")
    public ResponseEntity<GameSessionDto> joinGameSession(@RequestBody PlayerDto playerDto, @PathVariable Long sessionId) {
        try {
            GameSession gameSession = gameSessionService.joinGameSession(playerDto, sessionId);
            metaWebsocketController.playerJoined(sessionId, playerDto);
            GameSessionDto gameSessionDto = gameSessionMapper.gameSessionToGameSessionDto(gameSession);
            return ResponseEntity.ok(gameSessionDto);
        } catch (NoSuchElementException ignore) {
            return ResponseEntity.notFound().build();
        }
    }


//    @GetMapping("/{sessionId}")
//    public ResponseEntity<GameSession> getGameSession(@PathVariable Integer sessionId) {
//        Optional<GameSession> gameSession = gameSessionService.getPrivateGameSession(sessionId);
//        return gameSession.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
//    }

}
