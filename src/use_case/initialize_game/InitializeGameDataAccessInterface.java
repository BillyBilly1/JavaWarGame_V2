package use_case.initialize_game;

import domain.entity.Player.IPlayer;
import domain.entity.board.IBoard;
import domain.entity.game.IGame;

public interface InitializeGameDataAccessInterface {

    IPlayer loadPlayer(boolean left);

    void setBoard(IBoard board);

    void setGame(IGame game);


}
