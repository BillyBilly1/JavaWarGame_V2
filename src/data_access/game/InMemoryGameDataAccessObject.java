package data_access.game;

import domain.entity.game.Game;
import domain.entity.game.IGame;

public class InMemoryGameDataAccessObject implements GameDataAccessInterface{

    private final IGame game;


    public InMemoryGameDataAccessObject(IGame game) {
        this.game = game;
    }

    @Override
    public IGame loadGame() {
        return this.game;
    }
}
