package com.rekish.backendspanishfool.model.dto.model;

import com.rekish.backendspanishfool.model.entity.session.GameSessionStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameSessionDto {
    private Long id;
    private String name;
    private GameSessionStatusEnum sessionStatus;
    private GameStateDto gameState;
    private Integer playerCount;
}
