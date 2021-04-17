package com.rekish.backendspanishfool.model.dto.messaging;

import com.rekish.backendspanishfool.model.dto.model.PlayerDto;
import com.rekish.backendspanishfool.model.entity.game.Card;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class MoveDto implements Serializable {
    private PlayerDto owner;
    private MoveType type;
    private List<Card> payload;

}
