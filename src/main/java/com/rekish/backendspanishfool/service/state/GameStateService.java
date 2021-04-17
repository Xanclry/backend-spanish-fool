package com.rekish.backendspanishfool.service.state;

import com.rekish.backendspanishfool.model.entity.game.Card;
import com.rekish.backendspanishfool.model.entity.state.GameState;
import com.rekish.backendspanishfool.service.ReadWriteService;

import java.util.List;

public interface GameStateService extends ReadWriteService<Long, GameState> {
    List<Card> takeCardsFromDeck(int n, GameState gameState);
}
