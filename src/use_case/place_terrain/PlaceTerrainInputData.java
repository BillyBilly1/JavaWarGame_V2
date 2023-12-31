package use_case.place_terrain;

import domain.entity.terrain.ITerrain;

public class PlaceTerrainInputData {

    private final int x;

    private final int y;

    private final String terrainType;

    public PlaceTerrainInputData(int x, int y, String terrainType) {
        this.x = x;
        this.y = y;
        this.terrainType = terrainType;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getTerrainType() {
        return terrainType;
    }
}
