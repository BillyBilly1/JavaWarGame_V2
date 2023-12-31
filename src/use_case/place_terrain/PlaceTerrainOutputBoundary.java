package use_case.place_terrain;

public interface PlaceTerrainOutputBoundary {
    void prepareSuccessView();

    void prepareFailView(String message);
}
