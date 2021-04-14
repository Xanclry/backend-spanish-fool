package com.rekish.backendspanishfool.model.mapper;

import com.rekish.backendspanishfool.model.dto.PlayerDto;
import com.rekish.backendspanishfool.model.entity.player.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlayerDtoMapper {
    PlayerDto playerToPlayerDto(Player entity);

    @Mapping(target = "uid", ignore = true)
    Player playerDtoToPlayer(PlayerDto dto);
}
