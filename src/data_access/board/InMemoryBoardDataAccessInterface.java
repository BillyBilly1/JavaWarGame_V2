package data_access.board;

import domain.entity.board.IBoard;

public class InMemoryBoardDataAccessInterface implements BoardDataAccessInterface{

    private IBoard board;

    @Override
    public IBoard loadBoard() {
        return board;
    }

    @Override
    public void setBoard(IBoard board) {
        if (this.board == null) {
            this.board = board;
        }
        else {
            throw new IllegalStateException("Board can only be set once.");
        }

    }

}
