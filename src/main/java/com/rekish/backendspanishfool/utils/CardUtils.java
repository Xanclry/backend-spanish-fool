package com.rekish.backendspanishfool.utils;

import com.rekish.backendspanishfool.model.card.RankEnum;
import com.rekish.backendspanishfool.model.card.SuitEnum;
import com.rekish.backendspanishfool.model.game.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CardUtils {

    private CardUtils() {}

    public static List<Card> getFullCardDeck() {
        List<Card> cardDeck = new ArrayList<>();
        Arrays.stream(SuitEnum.values()).forEach(suit -> Arrays.stream(RankEnum.values()).forEach(rank -> cardDeck.add(new Card(rank, suit))));
        Collections.shuffle(cardDeck);
        return cardDeck;
    }
}
