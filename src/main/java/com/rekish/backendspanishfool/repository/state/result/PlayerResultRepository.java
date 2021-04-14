package com.rekish.backendspanishfool.repository.state.result;

import com.rekish.backendspanishfool.model.entity.state.result.PlayerResult;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerResultRepository extends CrudRepository<PlayerResult, Long> {
}
