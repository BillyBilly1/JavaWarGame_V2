package domain.entity.game;

import domain.entity.Player.IPlayer;
import domain.entity.board.IBoard;

public class GameFactory implements IGameFactory{

    @Override
    public IGame createGame(IBoard board, IPlayer player1, IPlayer player2) {
        return new Game(board, player1, player2);
    }
}
