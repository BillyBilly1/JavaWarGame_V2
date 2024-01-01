package use_case.place_building;

import exception.TileOccupiedException;

import java.lang.reflect.InvocationTargetException;

public interface PlaceBuildingInputBoundary {
    void execute(PlaceBuildingInputData placeBuildingInputData) throws
            InvocationTargetException, InstantiationException,
            IllegalAccessException, NoSuchMethodException, TileOccupiedException;;
}
