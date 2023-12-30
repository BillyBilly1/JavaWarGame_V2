package database.board;

import domain.entity.board.IBoard;

public interface BoardRepositoryInterface {

    IBoard loadBoard();

    void setBoard(IBoard board);

}
