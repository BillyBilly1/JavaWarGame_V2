package data_access.player;

import domain.entity.Player.IPlayer;

public interface PlayerDataAccessInterface {

    IPlayer loadPlayer(boolean left);
}
