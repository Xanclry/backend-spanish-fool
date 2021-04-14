package com.rekish.backendspanishfool.model.dto;

import com.rekish.backendspanishfool.model.game.ChestItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerStateDto {
    private PlayerDto player;
    private Integer handSize;
    private List<ChestItem> chestItems;
    private Boolean isGameOwner;
    private Integer moveOrder;
}
