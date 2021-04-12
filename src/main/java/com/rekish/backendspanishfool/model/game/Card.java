package com.rekish.backendspanishfool.model.game;

import com.rekish.backendspanishfool.model.card.RankEnum;
import com.rekish.backendspanishfool.model.card.SuitEnum;
import lombok.Data;

@Data
public class Card {
    private RankEnum rank;
    private SuitEnum suit;
}
