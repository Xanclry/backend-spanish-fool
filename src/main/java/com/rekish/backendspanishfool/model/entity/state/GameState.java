package com.rekish.backendspanishfool.model.entity.state;

import com.rekish.backendspanishfool.model.entity.session.GameSession;
import com.rekish.backendspanishfool.model.entity.game.Card;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class GameState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "gameState")
    private Set<PlayerState> playerStates;

    private Integer discardedCardsAmount;

    @ElementCollection
    @AttributeOverride(name = "suit", column = @Column(name = "cardStack_suit"))
    @AttributeOverride(name = "rank", column = @Column(name = "cardStack_rank"))
    private List<Card> cardStack;

    @ElementCollection
    @AttributeOverride(name = "suit", column = @Column(name = "deck_suit"))
    @AttributeOverride(name = "rank", column = @Column(name = "deck_rank"))
    private List<Card> deck;

    @OneToOne(mappedBy = "gameState")
    private GameSession gameSession;

    private Integer moveCount;

    public GameState(Set<PlayerState> playerStates, Integer discardedCardsAmount, List<Card> cardStack, List<Card> deck, GameSession gameSession, Integer moveCount) {
        this.playerStates = playerStates;
        this.discardedCardsAmount = discardedCardsAmount;
        this.cardStack = cardStack;
        this.deck = deck;
        this.gameSession = gameSession;
        this.moveCount = moveCount;
    }
}
