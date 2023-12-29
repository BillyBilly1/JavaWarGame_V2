package domain.entity.board;

public class BoardFactory implements IBoardFactory{

    @Override
    public IBoard createBoard(int width, int height) {
        return new Board(width, height);
    }
}
