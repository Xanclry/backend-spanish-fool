package com.rekish.backendspanishfool.model.entity.state;

import com.rekish.backendspanishfool.model.entity.game.Card;
import com.rekish.backendspanishfool.model.entity.session.GameSession;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"playerStates", "gameSession"})
@ToString(exclude = {"playerStates", "gameSession"})

@Entity
public class GameState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "gameState", cascade = CascadeType.ALL)
    private Set<PlayerState> playerStates = new HashSet<>();

    private Integer discardedCardsAmount = 0;

    @ElementCollection
    @AttributeOverride(name = "suit", column = @Column(name = "cardStack_suit"))
    @AttributeOverride(name = "rank", column = @Column(name = "cardStack_rank"))
    private List<Card> cardStack = new ArrayList<>();

    @ElementCollection
    @AttributeOverride(name = "suit", column = @Column(name = "deck_suit"))
    @AttributeOverride(name = "rank", column = @Column(name = "deck_rank"))
    private List<Card> deck;

    @OneToOne(mappedBy = "gameState", cascade = CascadeType.ALL)
    private GameSession gameSession;

    private Integer moveCount = 0;

    public GameState(Set<PlayerState> playerStates, Integer discardedCardsAmount, List<Card> cardStack, List<Card> deck, GameSession gameSession, Integer moveCount) {
        this.playerStates = playerStates;
        this.discardedCardsAmount = discardedCardsAmount;
        this.cardStack = cardStack;
        this.deck = deck;
        this.gameSession = gameSession;
        this.moveCount = moveCount;
    }
}
