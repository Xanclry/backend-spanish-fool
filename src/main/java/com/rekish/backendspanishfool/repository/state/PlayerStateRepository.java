package com.rekish.backendspanishfool.repository.state;

import com.rekish.backendspanishfool.model.entity.state.PlayerState;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerStateRepository extends CrudRepository<PlayerState, Long> {
}
