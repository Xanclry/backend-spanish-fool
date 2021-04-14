package com.rekish.backendspanishfool.controller;

import com.rekish.backendspanishfool.model.session.GameSession;
import com.rekish.backendspanishfool.model.session.PrivateGameSession;
import com.rekish.backendspanishfool.service.session.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/session")
@AllArgsConstructor
@CrossOrigin("*")
public class SessionController {

    private final SessionService sessionService;

    @GetMapping("/open")
    public ResponseEntity<List<GameSession>> getOpenGameSessions() {
        return ResponseEntity.ok(sessionService.getOpenGameSessions());
    }

    @GetMapping("/{sessionId}")
    public ResponseEntity<PrivateGameSession> getGameSession(@PathVariable Integer sessionId) {
        Optional<PrivateGameSession> gameSession = sessionService.getPrivateGameSession(sessionId);
        return gameSession.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());
    }

//    @PostMapping("/subscribe")
//    public ResponseEntity<PrivateGameSession> newSessionSubscriber(@RequestBody String uid) {
//
//    }

}
