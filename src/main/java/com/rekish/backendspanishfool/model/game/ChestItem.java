package com.rekish.backendspanishfool.model.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class ChestItem {
    @Embedded
    @AttributeOverride(name = "rank", column = @Column(name = "topCard.rank"))
    @AttributeOverride(name = "suit", column = @Column(name = "topCard.suit"))
    private Card topCard;

    @Embedded
    @AttributeOverride(name = "rank", column = @Column(name = "bottomCard.rank"))
    @AttributeOverride(name = "suit", column = @Column(name = "bottomCard.suit"))
    private Card bottomCard;
}
