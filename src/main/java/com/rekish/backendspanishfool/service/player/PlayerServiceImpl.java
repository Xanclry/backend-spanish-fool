package com.rekish.backendspanishfool.service.player;

import com.rekish.backendspanishfool.model.dto.model.PlayerDto;
import com.rekish.backendspanishfool.model.entity.player.Player;
import com.rekish.backendspanishfool.model.mapper.PlayerDtoMapper;
import com.rekish.backendspanishfool.service.ReadWriteServiceImpl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PlayerServiceImpl extends ReadWriteServiceImpl<String, Player> implements PlayerService {

    private final PlayerDtoMapper playerDtoMapper;

    protected PlayerServiceImpl(CrudRepository<Player, String> crudRepository, PlayerDtoMapper playerDtoMapper) {
        super(crudRepository);
        this.playerDtoMapper = playerDtoMapper;
    }

    @Override
    public Player findOrCreate(PlayerDto playerDto) {
        if (!isExistById(playerDto.getUid())) {
            persist(playerDtoMapper.playerDtoToPlayer(playerDto));
        }
        return getByKey(playerDto.getUid()).get();
    }

}
