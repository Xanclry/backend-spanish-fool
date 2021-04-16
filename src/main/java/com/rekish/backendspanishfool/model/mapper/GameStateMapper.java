package com.rekish.backendspanishfool.model.mapper;

import com.rekish.backendspanishfool.model.dto.model.GameStateDto;
import com.rekish.backendspanishfool.model.entity.state.GameState;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = PlayerStateMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class GameStateMapper {

    @Autowired
    private PlayerStateMapper playerStateMapper;

    public GameState gameStateDtoToGameState(GameStateDto dto) {
        GameState entity = new GameState();
        entity.setPlayerStates(new HashSet<>());
        entity.setDiscardedCardsAmount(dto.getDiscardedCardsAmount());
        entity.setCardStack(dto.getCardStack());
        entity.setDeck(new ArrayList<>(dto.getDeckSize()));
        entity.setMoveCount(dto.getMoveCount());
        return entity;
    }

    public GameStateDto gameStateToGameStateDto(GameState entity) {
        GameStateDto dto = new GameStateDto();
        dto.setPlayerStates(entity.getPlayerStates().stream().map(e -> playerStateMapper.playerStateToPlayerStateDto(e)).collect(Collectors.toSet()));
        dto.setDiscardedCardsAmount(entity.getDiscardedCardsAmount());
        dto.setCardStack(entity.getCardStack());
        dto.setDeckSize(entity.getDeck().size());
        dto.setMoveCount(entity.getMoveCount());
        return dto;
    }
}
