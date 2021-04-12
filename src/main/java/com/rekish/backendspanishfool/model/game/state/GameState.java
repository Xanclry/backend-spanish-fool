package com.rekish.backendspanishfool.model.game.state;

import com.rekish.backendspanishfool.model.game.Card;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class GameState {
    private Set<PlayerState> playerStates;
    private Integer discardedCardsAmount;
    private List<Card> cardStack;
    private List<Card> deck;
}
