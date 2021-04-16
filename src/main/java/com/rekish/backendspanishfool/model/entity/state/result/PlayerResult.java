package com.rekish.backendspanishfool.model.entity.state.result;

import com.rekish.backendspanishfool.model.entity.state.PlayerState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class PlayerResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "playerResult")
    private PlayerState playerState;

    @Enumerated(value = EnumType.STRING)
    private PlayerGameResultEnum gameResult;
}
