package com.rekish.backendspanishfool.model.mapper;

import com.rekish.backendspanishfool.model.dto.GameStateDto;
import com.rekish.backendspanishfool.model.entity.state.GameState;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.HashSet;

@Mapper(componentModel = "spring")
public interface GameStateMapper {

    default GameState gameStateDtoToGameState(GameStateDto dto) {
        GameState entity = new GameState();
        entity.setPlayerStates(new HashSet<>());
        entity.setDiscardedCardsAmount(dto.getDiscardedCardsAmount());
        entity.setCardStack(dto.getCardStack());
        entity.setDeck(new ArrayList<>(dto.getDeckSize()));
        entity.setMoveCount(dto.getMoveCount());
        return entity;
    }

    default GameStateDto gameStateToGameStateDto(GameState entity) {
        GameStateDto dto = new GameStateDto();
        dto.setDiscardedCardsAmount(entity.getDiscardedCardsAmount());
        dto.setCardStack(entity.getCardStack());
        dto.setDeckSize(entity.getDeck().size());
        dto.setMoveCount(entity.getMoveCount());
        return dto;
    }
}
