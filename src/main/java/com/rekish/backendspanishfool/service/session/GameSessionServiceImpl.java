package com.rekish.backendspanishfool.service.session;

import com.rekish.backendspanishfool.model.dto.model.PlayerDto;
import com.rekish.backendspanishfool.model.dto.session.NewSessionDto;
import com.rekish.backendspanishfool.model.entity.game.Card;
import com.rekish.backendspanishfool.model.entity.player.Player;
import com.rekish.backendspanishfool.model.entity.session.GameSession;
import com.rekish.backendspanishfool.model.entity.session.GameSessionStatusEnum;
import com.rekish.backendspanishfool.model.entity.state.GameState;
import com.rekish.backendspanishfool.model.entity.state.PlayerState;
import com.rekish.backendspanishfool.model.entity.state.result.PlayerGameResultEnum;
import com.rekish.backendspanishfool.repository.GameSessionRepository;
import com.rekish.backendspanishfool.service.ReadWriteServiceImpl;
import com.rekish.backendspanishfool.service.player.PlayerService;
import com.rekish.backendspanishfool.service.state.GameStateService;
import com.rekish.backendspanishfool.service.state.PlayerStateService;
import com.rekish.backendspanishfool.utils.CardUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class GameSessionServiceImpl extends ReadWriteServiceImpl<Long, GameSession> implements GameSessionService {

    @Value("${game.max-card-in-hand}")
    private Integer maxCardInHand;

    private final GameSessionRepository gameSessionRepository;
    private final GameStateService gameStateService;
    private final PlayerService playerService;
    private final PlayerStateService playerStateService;

    public GameSessionServiceImpl(GameSessionRepository gameSessionRepository, GameStateService gameStateService, PlayerService playerService, PlayerStateService playerStateService) {
        super(gameSessionRepository);
        this.gameSessionRepository = gameSessionRepository;
        this.gameStateService = gameStateService;
        this.playerService = playerService;
        this.playerStateService = playerStateService;
    }

    @Override
    public List<GameSession> getOpenGameSessions() {
        // todo create repository method
        Iterable<GameSession> all = gameSessionRepository.findAll();
        return StreamSupport.stream(all.spliterator(), false).filter(gameSession -> gameSession.getSessionStatus().equals(GameSessionStatusEnum.OPEN)).collect(Collectors.toList());
    }

    @Override
    public GameSession joinGameSession(PlayerDto playerDto, Long sessionId) throws NoSuchElementException {
        GameSession gameSession = gameSessionRepository.findById(sessionId).orElseThrow(NoSuchElementException::new);
        GameState gameState = gameSession.getGameState();
        Optional<PlayerState> passedPlayerInGameSession = gameState.getPlayerStates().stream().filter(state -> state.getPlayer().getUid().equals(playerDto.getUid())).findAny();
        if (passedPlayerInGameSession.isPresent()) {
            return gameSession;
        }

        Player player = playerService.findOrCreate(playerDto);
        List<Card> handCards = gameStateService.takeCardsFromDeck(maxCardInHand, gameState);

        PlayerState playerState = playerStateService.createPlayerState(player, false, gameState.getPlayerStates().size(), PlayerGameResultEnum.PLAYING);
        playerState.setHandCard(handCards);
        playerState.setGameState(gameState);

        gameState.getPlayerStates().add(playerState);
        gameStateService.persist(gameState);
        return gameSession;
    }


    @Override
    public GameSession createOpenGameSession(NewSessionDto sessionDto) {
        Player owner = playerService.findOrCreate(sessionDto.getOwner());

        PlayerState playerState = playerStateService.createPlayerState(owner, true, 0, PlayerGameResultEnum.PLAYING);


        GameState gameState = new GameState();
        gameState.setDeck(CardUtils.getFullCardDeck());
        gameState.getPlayerStates().add(playerState);

        List<Card> handCards = gameStateService.takeCardsFromDeck(maxCardInHand, gameState);
        playerState.setHandCard(handCards);

        GameSession gameSession = new GameSession();
        gameSession.setName(sessionDto.getName());
        gameSession.setSessionStatus(GameSessionStatusEnum.OPEN);

        gameState.setGameSession(gameSession);
        gameSession.setGameState(gameState);
        playerState.setGameState(gameState);

        persist(gameSession);
        return gameSession;
    }

}
