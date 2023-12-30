package database.player;

import domain.entity.Player.IPlayer;

public interface PlayerRepositoryInterface {

    IPlayer loadPlayer(boolean left);

    void setPlayer(IPlayer player);
}
