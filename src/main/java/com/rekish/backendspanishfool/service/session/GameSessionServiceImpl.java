package com.rekish.backendspanishfool.service.session;

import com.rekish.backendspanishfool.model.entity.session.GameSession;
import com.rekish.backendspanishfool.model.entity.session.GameSessionStatusEnum;
import com.rekish.backendspanishfool.repository.GameSessionRepository;
import com.rekish.backendspanishfool.service.ReadWriteServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class GameSessionServiceImpl extends ReadWriteServiceImpl<Long, GameSession> implements GameSessionService {

    private final GameSessionRepository gameSessionRepository;

    public GameSessionServiceImpl(GameSessionRepository gameSessionRepository) {
        super(gameSessionRepository);
        this.gameSessionRepository = gameSessionRepository;
    }

    @Override
    public List<GameSession> getOpenGameSessions() {
        // todo create repository method
        return StreamSupport.stream(gameSessionRepository.findAll().spliterator(), false).filter(gameSession -> gameSession.getSessionStatus().equals(GameSessionStatusEnum.OPEN)).collect(Collectors.toList());
    }

}
