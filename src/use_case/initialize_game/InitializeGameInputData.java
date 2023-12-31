package use_case.initialize_game;

public class InitializeGameInputData {

    private final String width;

    private final String height;

    public InitializeGameInputData(String width, String height) {
        this.width = width;
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public String getHeight() {
        return height;
    }
}
