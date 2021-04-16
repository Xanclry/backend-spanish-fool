package com.rekish.backendspanishfool.service.player;

import com.rekish.backendspanishfool.model.dto.model.PlayerDto;
import com.rekish.backendspanishfool.model.entity.player.Player;
import com.rekish.backendspanishfool.service.ReadWriteService;

public interface PlayerService extends ReadWriteService<String, Player> {
    Player findOrCreate(PlayerDto playerDto);
}
