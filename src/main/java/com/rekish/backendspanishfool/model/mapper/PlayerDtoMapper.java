package com.rekish.backendspanishfool.model.mapper;

import com.rekish.backendspanishfool.model.dto.model.PlayerDto;
import com.rekish.backendspanishfool.model.entity.player.Player;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerDtoMapper {
    PlayerDto playerToPlayerDto(Player entity);

    Player playerDtoToPlayer(PlayerDto dto);
}
