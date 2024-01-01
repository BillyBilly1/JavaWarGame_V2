package use_case.place_building;

import exception.InvalidPlacementException;
import exception.MoneyNotEnoughException;
import exception.TileOccupiedException;

import java.lang.reflect.InvocationTargetException;

public interface PlaceBuildingInputBoundary {
    void execute(PlaceBuildingInputData placeBuildingInputData) throws
            InvocationTargetException, InstantiationException,
            IllegalAccessException, NoSuchMethodException, TileOccupiedException, MoneyNotEnoughException, InvalidPlacementException;;
}
