package com.rekish.backendspanishfool.model.mapper;

import com.rekish.backendspanishfool.model.dto.GameSessionDto;
import com.rekish.backendspanishfool.model.entity.session.GameSession;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GameSessionMapper {

    @Mapping(target = "id", ignore = true)
    GameSession gameSessionDtoToGameSession(GameSessionDto dto);
    GameSessionDto gameSessionToGameSessionDto(GameSession entity);
}
