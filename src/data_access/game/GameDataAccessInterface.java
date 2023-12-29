package data_access.game;

import domain.entity.game.IGame;

public interface GameDataAccessInterface {

    IGame loadGame();

    void setGame(IGame game);
}
