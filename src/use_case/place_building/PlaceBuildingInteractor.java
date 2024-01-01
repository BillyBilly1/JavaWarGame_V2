package use_case.place_building;

import domain.entity.Player.IPlayer;
import domain.entity.board.IBoard;
import domain.entity.unit.IUnitFactory;
import domain.entity.unit.building.IBuilding;
import exception.InvalidPlacementException;
import exception.TileOccupiedException;

import java.lang.reflect.InvocationTargetException;

public class PlaceBuildingInteractor implements PlaceBuildingInputBoundary{

    final PlaceBuildingDataAccessInterface placeBuildingDataAccessObject;

    final PlaceBuildingOutputBoundary placeBuildingOutputPresenter;

    final IUnitFactory unitFactory;


    public PlaceBuildingInteractor(PlaceBuildingDataAccessInterface placeBuildingDataAccessObject,
                                   PlaceBuildingOutputBoundary placeBuildingOutputPresenter,
                                   IUnitFactory unitFactory) {
        this.placeBuildingDataAccessObject = placeBuildingDataAccessObject;
        this.placeBuildingOutputPresenter = placeBuildingOutputPresenter;
        this.unitFactory = unitFactory;
    }

    @Override
    public void execute(PlaceBuildingInputData placeBuildingInputData) throws
            InvocationTargetException, InstantiationException,
            IllegalAccessException, NoSuchMethodException {
        int x = placeBuildingInputData.getX();;
        int y = placeBuildingInputData.getY();
        boolean left = placeBuildingInputData.isLeft();
        String buildingType = placeBuildingInputData.getBuildingType();
        IBoard board = placeBuildingDataAccessObject.loadBoard();

        if (!board.isOccupied(x, y)) {
            try {
                // Create the combatUnit and put it onto the board and into the user's combatUnit list
                IBuilding building = (IBuilding) unitFactory.createUnit(buildingType, x, y, left);
                board.placePiece(x, y, building);
                IPlayer player = placeBuildingDataAccessObject.loadPlayer(left);
                player.addBuilding(building, board.getWidth());

                PlaceBuildingOutputData placeBuildingOutputData =
                        new PlaceBuildingOutputData(buildingType + " is successfully placed.");
                placeBuildingOutputPresenter.prepareSuccessView(placeBuildingOutputData);
            } catch (TileOccupiedException | InvalidPlacementException e) {
                PlaceBuildingOutputData placeBuildingOutputData =
                        new PlaceBuildingOutputData(e.getMessage());
                placeBuildingOutputPresenter.prepareFailView(placeBuildingOutputData);
            }
        }
        else {
            String message = "Position at (" + x + ", " + y + ") is already occupied.";
            placeBuildingOutputPresenter.prepareFailView(new PlaceBuildingOutputData(message));
        }
    }
}


