package use_case.attack;

import domain.entity.Player.IPlayer;
import domain.entity.board.IBoard;

public interface AttackDataAccessInterface {

    IPlayer loadPlayer(boolean left);

    IBoard loadBoard();
}
