package com.rekish.backendspanishfool.repository;

import com.rekish.backendspanishfool.model.entity.session.GameSession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameSessionRepository extends CrudRepository<GameSession, Long> {
}
