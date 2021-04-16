package com.rekish.backendspanishfool.model.entity.player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Player {

    @Id
    private String uid;
    private String email;

}
