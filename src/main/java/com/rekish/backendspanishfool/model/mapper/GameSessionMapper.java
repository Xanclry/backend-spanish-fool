package com.rekish.backendspanishfool.model.mapper;

import com.rekish.backendspanishfool.model.dto.model.GameSessionDto;
import com.rekish.backendspanishfool.model.entity.session.GameSession;
import com.rekish.backendspanishfool.model.entity.state.GameState;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = GameStateMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface GameSessionMapper {

    GameSession gameSessionDtoToGameSession(GameSessionDto dto);

    @Mapping(target = "playerCount", expression = "java(getPlayerCount(entity.getGameState()))")
    GameSessionDto gameSessionToGameSessionDto(GameSession entity);

    default Integer getPlayerCount(GameState gameState) {
        return gameState.getPlayerStates().size();
    }

}
