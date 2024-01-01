package use_case.place_terrain;

public interface PlaceTerrainOutputBoundary {
    void prepareSuccessView(PlaceTerrainOutputData placeTerrainOutputData);

    void prepareFailView(PlaceTerrainOutputData placeTerrainOutputData);
}
