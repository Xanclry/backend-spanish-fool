package com.rekish.backendspanishfool.service.state;

import com.rekish.backendspanishfool.model.entity.game.Card;
import com.rekish.backendspanishfool.model.entity.state.GameState;
import com.rekish.backendspanishfool.service.ReadWriteServiceImpl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GameStateServiceImpl extends ReadWriteServiceImpl<Long, GameState> implements GameStateService {
    protected GameStateServiceImpl(CrudRepository<GameState, Long> crudRepository) {
        super(crudRepository);
    }

    @Override
    public List<Card> takeCardsFromDeck(int n, GameState gameState) {
        return popCards(n, gameState);
    }

    private List<Card> popCards(int n, GameState gameState) {
        List<Card> deck = gameState.getDeck();
        if (deck.size() < n) {
            return new ArrayList<>();
        }
        int startIndex = deck.size() - n;
        List<Card> subList = deck.subList(startIndex, deck.size());
        ArrayList<Card> result = new ArrayList<>(subList);
        subList.clear();
        return result;
    }
}
