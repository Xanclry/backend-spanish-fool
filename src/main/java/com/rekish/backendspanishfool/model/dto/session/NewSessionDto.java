package com.rekish.backendspanishfool.model.dto.session;

import com.rekish.backendspanishfool.model.dto.model.PlayerDto;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class NewSessionDto implements Serializable {
    @NotEmpty
    private String name;
    @Valid
    private PlayerDto owner;
}
