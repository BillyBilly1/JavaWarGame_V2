package data_access;

import database.player.PlayerRepositoryInterface;
import domain.entity.Player.IPlayer;
import use_case.set_up_players.SetUpPlayersDataAccessInterface;

public class SetUpPlayerDataAccessObject implements SetUpPlayersDataAccessInterface {

    private final PlayerRepositoryInterface playerRepository;

    public SetUpPlayerDataAccessObject(PlayerRepositoryInterface playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void setPlayer(IPlayer player) {
        playerRepository.setPlayer(player);

    }
}
