package com.rekish.backendspanishfool.model.entity.move;

import com.rekish.backendspanishfool.model.entity.player.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractMove {
    private Player player;
    private Integer moveCounter;
}
