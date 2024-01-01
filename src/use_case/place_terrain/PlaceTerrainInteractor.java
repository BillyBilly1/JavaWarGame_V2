package use_case.place_terrain;

import domain.entity.board.IBoard;
import domain.entity.terrain.ITerrain;
import domain.entity.terrain.ITerrainFactory;
import exception.TileOccupiedException;

import java.lang.reflect.InvocationTargetException;

public class PlaceTerrainInteractor implements PlaceTerrainInputBoundary {

    final PlaceTerrainDataAccessInterface placeTerrainDataAccessObject;

    final PlaceTerrainOutputBoundary placeTerrainPresenter;

    final ITerrainFactory terrainFactory;


    public PlaceTerrainInteractor(PlaceTerrainDataAccessInterface placeTerrainDataAccessObject,
                                  PlaceTerrainOutputBoundary placeTerrainPresenter,
                                  ITerrainFactory terrainFactory) {
        this.placeTerrainDataAccessObject = placeTerrainDataAccessObject;
        this.placeTerrainPresenter = placeTerrainPresenter;
        this.terrainFactory = terrainFactory;
    }

    @Override
    public void execute(PlaceTerrainInputData placeTerrainInputData) throws
            InvocationTargetException, InstantiationException,
            IllegalAccessException, NoSuchMethodException {
        int x = placeTerrainInputData.getX();
        int y = placeTerrainInputData.getY();
        String terrainType = placeTerrainInputData.getTerrainType();
        IBoard board = placeTerrainDataAccessObject.loadBoard();
        // First check to make sure that x, y is not occupied.
        if (!board.isOccupied(x, y)) {
            ITerrain terrain = terrainFactory.createTerrain(terrainType, x, y);
            try {
                board.placePiece(x, y, terrain);
                PlaceTerrainOutputData placeTerrainOutputData =
                        new PlaceTerrainOutputData("Terrain is successfully set.");
                placeTerrainPresenter.prepareSuccessView(placeTerrainOutputData);
            } catch (TileOccupiedException e) {
                // Second check to make sure that x, y is not occupied,
                // although this exception is supposed to be not thrown anyway.
                PlaceTerrainOutputData placeTerrainOutputData =
                        new PlaceTerrainOutputData(e.getMessage());
                placeTerrainPresenter.prepareFailView(placeTerrainOutputData);
            }
        } else {
            String message = "Position at (" + x + ", " + y + ") is already occupied.";
            placeTerrainPresenter.prepareFailView(new PlaceTerrainOutputData(message));
        }
    }
}


