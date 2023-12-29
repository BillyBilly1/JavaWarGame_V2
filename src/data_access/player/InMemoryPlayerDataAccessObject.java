package data_access.player;

import domain.entity.Player.IPlayer;

public class InMemoryPlayerDataAccessObject implements PlayerDataAccessInterface{

    private final IPlayer player1;

    private final IPlayer player2;

    public InMemoryPlayerDataAccessObject(IPlayer player1, IPlayer player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public IPlayer loadPlayer(boolean left) {
        return left ? player1 : player2;
    }
}
