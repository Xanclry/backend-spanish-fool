package com.rekish.backendspanishfool.repository;

import com.rekish.backendspanishfool.model.entity.player.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, String> {
}
