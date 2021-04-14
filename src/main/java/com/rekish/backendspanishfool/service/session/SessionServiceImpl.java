package com.rekish.backendspanishfool.service.session;

import com.rekish.backendspanishfool.model.game.state.GameState;
import com.rekish.backendspanishfool.model.game.state.PlayerState;
import com.rekish.backendspanishfool.model.session.GameSession;
import com.rekish.backendspanishfool.model.session.PrivateGameSession;
import com.rekish.backendspanishfool.model.session.status.GameSessionStatusEnum;
import com.rekish.backendspanishfool.utils.CardUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SessionServiceImpl implements SessionService {

    private List<GameSession> gameSessions = new ArrayList<>();
    private List<PrivateGameSession> privateGameSessions = new ArrayList<>();

    public SessionServiceImpl() {
        gameSessions.add(new GameSession(
                1L,
                "First game session",
                GameSessionStatusEnum.OPEN,
                0));
        gameSessions.add(new GameSession(
                2L,
                "Second game session",
                GameSessionStatusEnum.PLAYING,
                2));

        privateGameSessions.add(new PrivateGameSession(1L, "First game session", GameSessionStatusEnum.OPEN, 0,
                new GameState(Collections.emptySet(), 0, Collections.emptyList(), CardUtils.getFullCardDeck())));
    }

    @Override
    public List<GameSession> getOpenGameSessions() {
        //todo implement

        return gameSessions;
    }

    @Override
    public Optional<PrivateGameSession> getPrivateGameSession(Integer sessionId) {
        return privateGameSessions.stream().filter(session -> session.getId().equals(Long.valueOf(sessionId))).findAny();

    }

//    @Override
//    public void newSessionSubscriber(String playerUid) {
//
//        new PlayerState()
//        privateGameSessions.get(0).getGameState().getPlayerStates().add()
//    }
}
