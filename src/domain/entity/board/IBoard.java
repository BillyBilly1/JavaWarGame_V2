package domain.entity.board;

import domain.entity.Placeable;

public interface IBoard {

    Placeable[][] getGrid();

    Placeable getPlaceableAt(int x, int y);

    void placePiece(int x, int y, Placeable placeable);

    void removePiece(Placeable placeable);

    int getWidth();

    int getHeight();
}
