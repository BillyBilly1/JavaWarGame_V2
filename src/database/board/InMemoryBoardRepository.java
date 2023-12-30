package database.board;

import domain.entity.board.IBoard;

public class InMemoryBoardRepository implements BoardRepositoryInterface{
    private IBoard board;

    public IBoard loadBoard() {
        return board;
    }

    public void setBoard(IBoard board) {
        if (this.board == null) {
            this.board = board;
        }
        else {
            throw new IllegalStateException("Board can only be set once.");
        }

    }

}
