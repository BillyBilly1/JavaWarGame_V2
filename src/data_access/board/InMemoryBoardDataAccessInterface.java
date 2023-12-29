package data_access.board;

import domain.entity.board.IBoard;

public class InMemoryBoardDataAccessInterface implements BoardDataAccessInterface{

    private final IBoard board;

    public InMemoryBoardDataAccessInterface(IBoard board) {
        this.board = board;
    }

    @Override
    public IBoard loadBoard() {
        return board;
    }



}
