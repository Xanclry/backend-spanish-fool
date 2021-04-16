package com.rekish.backendspanishfool.service.state;

import com.rekish.backendspanishfool.model.entity.player.Player;
import com.rekish.backendspanishfool.model.entity.state.PlayerState;
import com.rekish.backendspanishfool.model.entity.state.result.PlayerGameResultEnum;
import com.rekish.backendspanishfool.service.ReadWriteService;

public interface PlayerStateService extends ReadWriteService<Long, PlayerState> {
    PlayerState createPlayerState(Player player, boolean isOwner, Integer moveOrder, PlayerGameResultEnum result);
}
