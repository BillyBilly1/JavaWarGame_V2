package database.player;

import domain.entity.Player.IPlayer;

public class InMemoryPlayerRepository implements PlayerRepositoryInterface{

    // The left attribute of player1 must always be true,
    // while that of player2 must always be false
    private IPlayer player1;

    private IPlayer player2;


    @Override
    public IPlayer loadPlayer(boolean left) {
        return left ? player1 : player2;
    }

    @Override
    public void setPlayer(IPlayer player) {
        if (player.isLeft()) {
            if (this.player1 == null) {
                this.player1 = player;
            }
            else {
                throw new IllegalStateException("Player1 is already set.");
            }
        }
        else {
            if (this.player2 == null) {
                this.player2 = player;
            }
            else {
                throw new IllegalStateException("Player2 is already set.");
            }
        }
    }
}
