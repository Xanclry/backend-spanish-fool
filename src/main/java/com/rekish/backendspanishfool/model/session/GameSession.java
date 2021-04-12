package com.rekish.backendspanishfool.model.session;

import com.rekish.backendspanishfool.model.game.state.GameState;
import com.rekish.backendspanishfool.model.session.status.GameSessionStatusEnum;
import lombok.Data;

@Data
public class GameSession {
    private GameSessionStatusEnum sessionStatus;
    private GameState gameState;
}
