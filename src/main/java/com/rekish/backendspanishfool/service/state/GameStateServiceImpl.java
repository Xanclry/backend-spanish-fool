package com.rekish.backendspanishfool.service.state;

import com.rekish.backendspanishfool.model.entity.state.GameState;
import com.rekish.backendspanishfool.service.ReadWriteServiceImpl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GameStateServiceImpl extends ReadWriteServiceImpl<Long, GameState> implements GameStateService {
    protected GameStateServiceImpl(CrudRepository<GameState, Long> crudRepository) {
        super(crudRepository);
    }
}
