package com.rekish.backendspanishfool.service.session;

import com.rekish.backendspanishfool.model.dto.model.PlayerDto;
import com.rekish.backendspanishfool.model.dto.session.NewSessionDto;
import com.rekish.backendspanishfool.model.entity.session.GameSession;
import com.rekish.backendspanishfool.service.ReadWriteService;

import java.util.List;

public interface GameSessionService extends ReadWriteService<Long, GameSession> {
    List<GameSession> getOpenGameSessions();

    GameSession joinGameSession(PlayerDto playerDto, Long sessionId);

    GameSession createOpenGameSession(NewSessionDto sessionDto);
}
