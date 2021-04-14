package com.rekish.backendspanishfool.model.mapper;

import com.rekish.backendspanishfool.model.dto.PlayerStateDto;
import com.rekish.backendspanishfool.model.entity.game.ChestItem;
import com.rekish.backendspanishfool.model.entity.state.PlayerState;
import lombok.AllArgsConstructor;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
@AllArgsConstructor
public abstract class PlayerStateMapper {

    private final PlayerDtoMapper playerDtoMapper;

    public PlayerState playerStateDtoToPlayerState(PlayerStateDto dto) {
        PlayerState entity = new PlayerState();
        entity.setPlayer(playerDtoMapper.playerDtoToPlayer(dto.getPlayer()));
        entity.setHandCard(new ArrayList<>(dto.getHandSize()));
        entity.setChestItems(dto.getChestItems());
        entity.setIsGameOwner(dto.getIsGameOwner());
        entity.setMoveOrder(dto.getMoveOrder());
        return entity;
    }

    public PlayerStateDto playerStateToPlayerStateDto(PlayerState entity) {
        PlayerStateDto dto = new PlayerStateDto();
        dto.setPlayer(playerDtoMapper.playerToPlayerDto(entity.getPlayer()));
        dto.setHandSize(entity.getHandCard().size());
        dto.setChestItems(entity.getChestItems().stream().map(chestItem -> {
            ChestItem dtoChestItem = new ChestItem();
            dtoChestItem.setTopCard(chestItem.getTopCard());
            if (dtoChestItem.getTopCard() == null) {
                dtoChestItem.setBottomCard(chestItem.getBottomCard());
            }
            return dtoChestItem;
        }).collect(Collectors.toList()));
        dto.setIsGameOwner(entity.getIsGameOwner());
        dto.setMoveOrder(entity.getMoveOrder());
        return dto;
    }
}
