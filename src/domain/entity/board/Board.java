package domain.entity.board;

import domain.entity.Placeable;

public class Board implements IBoard{

    private final Placeable[][] grid;

    private final int width;

    private final int height;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new Placeable[width][height];
    }

    @Override
    public Placeable[][] getGrid() {
        Placeable[][] gridCopy = new Placeable[width][height];
        for (int i = 0; i < width; i++) {
            System.arraycopy(grid[i], 0, gridCopy[i], 0, height);
        }
        return gridCopy;
    }

    @Override
    public Placeable getPlaceableAt(int x, int y) {
        return grid[x][y];
    }

    @Override
    public void placePiece(int x, int y, Placeable placeable) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            throw new IndexOutOfBoundsException("Position (" + x + ", " + y + ") is out of the board's bounds.");
        }
        if (grid[x][y] != null) {
            throw new IllegalStateException("Position (" + x + ", " + y + ") is already occupied.");
        }
        grid[x][y] = placeable;
    }

    @Override
    public void removePiece(Placeable placeable) {
        int x = placeable.getX();
        int y = placeable.getY();
        if (x >= 0 && x < width && y >= 0 && y < height) {
            if (grid[x][y] == placeable) {
                grid[x][y] = null;
            } else {
                throw new IllegalArgumentException("Placeable is not at this position.");
            }
        } else {
            throw new IndexOutOfBoundsException("Position (" + x + ", " + y + ") is out of the board's bounds.");
        }
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
