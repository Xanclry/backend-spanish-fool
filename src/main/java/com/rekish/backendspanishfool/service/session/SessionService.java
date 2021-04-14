package com.rekish.backendspanishfool.service.session;

import com.rekish.backendspanishfool.model.session.GameSession;
import com.rekish.backendspanishfool.model.session.PrivateGameSession;

import java.util.List;
import java.util.Optional;

public interface SessionService {
    List<GameSession> getOpenGameSessions();

    Optional<PrivateGameSession> getPrivateGameSession(Integer sessionId);
}
