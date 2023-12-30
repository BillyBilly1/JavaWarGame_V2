package database.game;

import domain.entity.game.IGame;

public class InMemoryGameRepository implements GameRepositoryInterface {

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
