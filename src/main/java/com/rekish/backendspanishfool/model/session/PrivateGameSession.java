package com.rekish.backendspanishfool.model.session;

import com.rekish.backendspanishfool.model.game.state.GameState;
import com.rekish.backendspanishfool.model.player.Player;
import com.rekish.backendspanishfool.model.session.status.GameSessionStatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PrivateGameSession extends GameSession {

    private GameState gameState;
    private Player gameOwner;

    public PrivateGameSession(Long id, String name, GameSessionStatusEnum sessionStatus, Integer playerCount, GameState gameState) {
        super(id, name, sessionStatus, playerCount);
        this.gameState = gameState;
    }
}
