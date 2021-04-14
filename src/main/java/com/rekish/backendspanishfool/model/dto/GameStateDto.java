package com.rekish.backendspanishfool.model.dto;

import com.rekish.backendspanishfool.model.entity.game.Card;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameStateDto {
    private Integer discardedCardsAmount;
    private List<Card> cardStack;
    private Integer deckSize;
    private Integer moveCount;
}
