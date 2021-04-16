package com.rekish.backendspanishfool.model.dto.model;

import com.rekish.backendspanishfool.model.entity.game.Card;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameStateDto {
    private Set<PlayerStateDto> playerStates;
    private Integer discardedCardsAmount;
    private List<Card> cardStack;
    private Integer deckSize;
    private Integer moveCount;
}
