package com.rekish.backendspanishfool.model.dto.messaging.meta;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MetaMessageDto {
    private PlayerStatusChanging action;
    private String playerUid;
}
