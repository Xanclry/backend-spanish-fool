package com.rekish.backendspanishfool.model.session;

import com.rekish.backendspanishfool.model.session.status.GameSessionStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameSession {
    private Long id;
    private String name;
    private GameSessionStatusEnum sessionStatus;
    private Integer playerCount;
}
