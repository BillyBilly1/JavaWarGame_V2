package use_case.place_terrain;

import domain.entity.board.IBoard;
import domain.entity.terrain.ITerrain;
import domain.entity.terrain.ITerrainFactory;
import exception.TileOccupiedException;

import java.lang.reflect.InvocationTargetException;

public class PlaceTerrainInteractor implements PlaceTerrainInputBoundary{

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
        ITerrain terrain = terrainFactory.createTerrain(terrainType, x, y);

        try {
            board.placePiece(x, y, terrain);
            placeTerrainPresenter.prepareSuccessView();
        }
        catch (TileOccupiedException e) {
            placeTerrainPresenter.prepareFailView(e.getMessage());
        }
    }
}

