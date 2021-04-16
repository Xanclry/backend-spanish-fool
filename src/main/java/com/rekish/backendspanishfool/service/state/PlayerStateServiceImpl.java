package com.rekish.backendspanishfool.service.state;

import com.rekish.backendspanishfool.model.entity.player.Player;
import com.rekish.backendspanishfool.model.entity.state.PlayerState;
import com.rekish.backendspanishfool.model.entity.state.result.PlayerGameResultEnum;
import com.rekish.backendspanishfool.model.entity.state.result.PlayerResult;
import com.rekish.backendspanishfool.service.ReadWriteServiceImpl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@Transactional
public class PlayerStateServiceImpl extends ReadWriteServiceImpl<Long, PlayerState> implements PlayerStateService {
    protected PlayerStateServiceImpl(CrudRepository<PlayerState, Long> crudRepository) {
        super(crudRepository);
    }

    @Override
    public PlayerState createPlayerState(Player player, boolean isOwner, Integer moveOrder, PlayerGameResultEnum result) {
        PlayerResult playerResult = new PlayerResult();
        playerResult.setGameResult(result);

        PlayerState playerState = new PlayerState();
        playerState.setPlayer(player);
        playerState.setPlayerResult(playerResult);
        playerState.setHandCard(new ArrayList<>());
        playerState.setChestItems(new ArrayList<>());
        playerState.setIsGameOwner(isOwner);
        playerState.setMoveOrder(moveOrder);

        playerResult.setPlayerState(playerState);

        persist(playerState);

        return playerState;
    }
}
