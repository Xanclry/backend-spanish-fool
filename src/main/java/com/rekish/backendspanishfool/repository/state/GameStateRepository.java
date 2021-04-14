package com.rekish.backendspanishfool.repository.state;

import com.rekish.backendspanishfool.model.entity.state.GameState;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameStateRepository extends CrudRepository<GameState, Long> {
}
