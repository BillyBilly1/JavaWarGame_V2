package domain.entity.board;

public interface IBoardFactory {

    IBoard createBoard(int width, int height);
}
