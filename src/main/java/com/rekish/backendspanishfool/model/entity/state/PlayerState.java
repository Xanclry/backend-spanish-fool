package com.rekish.backendspanishfool.model.entity.state;

import com.rekish.backendspanishfool.model.entity.player.Player;
import com.rekish.backendspanishfool.model.entity.state.result.PlayerResult;
import com.rekish.backendspanishfool.model.game.Card;
import com.rekish.backendspanishfool.model.game.ChestItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class PlayerState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "player_uid")
    private Player player;

    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "game_state_id")
    private GameState gameState;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player_result_id")
    private PlayerResult playerResult;

    @ElementCollection
    @AttributeOverride(name = "suit", column = @Column(name = "handCard_suit"))
    @AttributeOverride(name = "rank", column = @Column(name = "handCard_rank"))
    private List<Card> handCard;

    @ElementCollection
    private List<ChestItem> chestItems;

    private Boolean isGameOwner;

    private Integer moveOrder;


}
