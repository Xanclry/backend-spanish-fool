package com.rekish.backendspanishfool.model.entity.game;

import com.rekish.backendspanishfool.model.entity.game.enums.RankEnum;
import com.rekish.backendspanishfool.model.entity.game.enums.SuitEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class Card {
    @Enumerated(value = EnumType.ORDINAL)
    private RankEnum rank;
    @Enumerated(value = EnumType.ORDINAL)
    private SuitEnum suit;
}
