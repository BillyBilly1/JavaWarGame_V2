package data_access.game;

import domain.entity.game.Game;
import domain.entity.game.IGame;

public class InMemoryGameDataAccessObject implements GameDataAccessInterface{

    private IGame game;

    @Override
    public IGame loadGame() {
        return this.game;
    }

    @Override
    public void setGame(IGame game) {
        if (this.game == null) {
            this.game = game;
        }
        else {
            throw new IllegalStateException("Game can only be set once.");
        }
    }
}
