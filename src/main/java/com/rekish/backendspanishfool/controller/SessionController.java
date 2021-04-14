package com.rekish.backendspanishfool.controller;

import com.rekish.backendspanishfool.model.dto.GameSessionDto;
import com.rekish.backendspanishfool.model.entity.session.GameSession;
import com.rekish.backendspanishfool.model.mapper.GameSessionMapper;
import com.rekish.backendspanishfool.service.session.GameSessionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/session")
@AllArgsConstructor
@CrossOrigin("*")
public class SessionController {

    private final GameSessionService gameSessionService;
    private final GameSessionMapper gameSessionMapper;

    @GetMapping("/open")
    public ResponseEntity<List<GameSessionDto>> getOpenGameSessions() {

        List<GameSession> openGameSessions = gameSessionService.getOpenGameSessions();
        return ResponseEntity.ok(openGameSessions.stream().map(gameSessionMapper::gameSessionToGameSessionDto).collect(Collectors.toList()));
    }

//    @GetMapping("/{sessionId}")
//    public ResponseEntity<GameSession> getGameSession(@PathVariable Integer sessionId) {
//        Optional<GameSession> gameSession = gameSessionService.getPrivateGameSession(sessionId);
//        return gameSession.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
//    }

//    @PostMapping("/subscribe")
//    public ResponseEntity<PrivateGameSession> newSessionSubscriber(@RequestBody String uid) {
//
//    }

}
