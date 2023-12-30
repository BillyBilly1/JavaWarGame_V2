package use_case.initialize_game;

public class InitializeGameInputData {

    private final int width;

    private final int height;

    public InitializeGameInputData(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
