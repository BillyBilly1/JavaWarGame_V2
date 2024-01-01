package use_case.place_building;

public class PlaceBuildingInputData {

    private final int x;

    private final int y;

    private final boolean left;

    private final String buildingType;

    public PlaceBuildingInputData(int x, int y, boolean left, String buildingType) {
        this.x = x;
        this.y = y;
        this.left = left;
        this.buildingType = buildingType;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isLeft() {
        return left;
    }

    public String getBuildingType() {
        return buildingType;
    }
}
