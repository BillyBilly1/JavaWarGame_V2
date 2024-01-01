package interface_adapter.initialize_game;

public class InitializeGameState {

    // Width and height are recommended to be 60 and 40, but may be changed
    private String width = "60";

    private String height = "40";

    private String widthErrorMessage = "";

    private String heightErrorMessage = "";

    private boolean validWidthInput = false;

    private boolean validHeightInput = false;

    public InitializeGameState(InitializeGameState copy) {
        width = copy.width;
        height = copy.height;
        widthErrorMessage = copy.widthErrorMessage;;
        heightErrorMessage = copy.heightErrorMessage;;
        validWidthInput = copy.validWidthInput;
        validHeightInput = copy.validHeightInput;;
    }

    public InitializeGameState() {}

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidthErrorMessage() {
        return widthErrorMessage;
    }

    public void setWidthErrorMessage(String widthErrorMessage) {
        this.widthErrorMessage = widthErrorMessage;
    }

    public String getHeightErrorMessage() {
        return heightErrorMessage;
    }

    public void setHeightErrorMessage(String heightErrorMessage) {
        this.heightErrorMessage = heightErrorMessage;
    }

    public boolean isValidWidthInput() {
        return validWidthInput;
    }

    public void setValidWidthInput(boolean validWidthInput) {
        this.validWidthInput = validWidthInput;
    }

    public boolean isValidHeightInput() {
        return validHeightInput;
    }

    public void setValidHeightInput(boolean validHeightInput) {
        this.validHeightInput = validHeightInput;
    }
}
