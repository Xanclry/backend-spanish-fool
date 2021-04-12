package com.rekish.backendspanishfool.model.game.state;

import com.rekish.backendspanishfool.model.game.Card;
import com.rekish.backendspanishfool.model.game.ChestItem;
import com.rekish.backendspanishfool.model.player.Player;
import lombok.Data;

import java.util.List;

@Data
public class PlayerState {
    private Player player;
    private List<Card> handCard;
    private List<ChestItem> chestItems;
}
