package domain.entity.game;

import domain.entity.Player.IPlayer;
import domain.entity.board.IBoard;

public interface IGameFactory {

    IGame createGame(IBoard board, IPlayer player1, IPlayer player2);
}
