package database.game;

import domain.entity.game.IGame;

public interface GameRepositoryInterface {

    IGame loadGame();

    void setGame(IGame game);
}
