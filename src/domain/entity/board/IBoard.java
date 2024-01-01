package domain.entity.board;

import domain.entity.Placeable;
import exception.TileOccupiedException;

public interface IBoard {

    Placeable[][] getGrid();

    Placeable getPlaceableAt(int x, int y);

    void placePiece(int x, int y, Placeable placeable) throws TileOccupiedException;

    void removePiece(Placeable placeable);

    void removePiece(int x, int y);

    int getWidth();

    int getHeight();

    boolean isOccupied(int x, int y);
}
