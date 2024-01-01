package use_case.place_terrain;

import exception.TileOccupiedException;

import java.lang.reflect.InvocationTargetException;

public interface PlaceTerrainInputBoundary {
    void execute(PlaceTerrainInputData placeTerrainInputData)
            throws InvocationTargetException, InstantiationException,
            IllegalAccessException, NoSuchMethodException, TileOccupiedException;
}
