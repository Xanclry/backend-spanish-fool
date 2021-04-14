package com.rekish.backendspanishfool.service.session;

import com.rekish.backendspanishfool.model.entity.session.GameSession;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SessionServiceImpl implements SessionService {

//    private List<GameSession> gameSessions = new ArrayList<>();
//    private List<PrivateGameSession> privateGameSessions = new ArrayList<>();
//
//    public SessionServiceImpl() {
//        gameSessions.add(new GameSession(
//                1L,
//                "First game session",
//                GameSessionStatusEnum.OPEN,
//                0));
//        gameSessions.add(new GameSession(
//                2L,
//                "Second game session",
//                GameSessionStatusEnum.PLAYING,
//                2));
//
//        privateGameSessions.add(new PrivateGameSession(1L, "First game session", GameSessionStatusEnum.OPEN, 0,
//                new GameState(Collections.emptySet(), 0, Collections.emptyList(), CardUtils.getFullCardDeck())));
//    }

    @Override
    public List<GameSession> getOpenGameSessions() {
        //todo implement

        return Collections.emptyList();
    }

    @Override
    public Optional<GameSession> getPrivateGameSession(Integer sessionId) {
        return Optional.empty();

    }

//    @Override
//    public void newSessionSubscriber(String playerUid) {
//
//        new PlayerState()
//        privateGameSessions.get(0).getGameState().getPlayerStates().add()
//    }
}
