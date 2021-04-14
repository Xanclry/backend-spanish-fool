package com.rekish.backendspanishfool.service.session;

import com.rekish.backendspanishfool.model.entity.session.GameSession;

import java.util.List;
import java.util.Optional;

public interface SessionService {
    List<GameSession> getOpenGameSessions();

    Optional<GameSession> getPrivateGameSession(Integer sessionId);
}
