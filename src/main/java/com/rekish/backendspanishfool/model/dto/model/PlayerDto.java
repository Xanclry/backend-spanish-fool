package com.rekish.backendspanishfool.model.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto implements Serializable {
    @NotEmpty
    private String uid;
    @NotEmpty
    private String email;
}
