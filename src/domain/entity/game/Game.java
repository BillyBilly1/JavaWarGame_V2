package domain.entity.game;

import domain.entity.Player.IPlayer;
import domain.entity.board.IBoard;

public class Game implements IGame{

    private final IBoard board;

    private final IPlayer player1;

    private final IPlayer player2;

    private int turn = 0;

    private boolean leftTure = true;

    public Game(IBoard board, IPlayer player1, IPlayer player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }
}
