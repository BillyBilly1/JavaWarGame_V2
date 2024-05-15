package use_case.place_building;

import domain.entity.Player.IPlayer;
import domain.entity.board.IBoard;
import domain.entity.unit.IUnitFactory;
import domain.entity.unit.building.IBuilding;
import java.lang.reflect.InvocationTargetException;

public class PlaceBuildingInteractor implements PlaceBuildingInputBoundary {
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
            InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        int x = placeBuildingInputData.getX();
        int y = placeBuildingInputData.getY();
        boolean left = placeBuildingInputData.isLeft();
        String buildingType = placeBuildingInputData.getBuildingType();
        IBoard board = placeBuildingDataAccessObject.loadBoard();
        IPlayer player = placeBuildingDataAccessObject.loadPlayer(left);

        IBuilding building = (IBuilding) unitFactory.createUnit(buildingType, x, y, left);

        String errorMessage = null;

        if (board.isOccupied(x, y)) {
            errorMessage = "Position at (" + x + ", " + y + ") is already occupied.";
        } else if (!player.canPlaceUnitAt(x, building.getHeight(), board.getWidth())) {
            errorMessage = "Invalid placement.";
        } else if (player.getMoney() < building.getPrice() * player.getPriceCoefficient()) {
            errorMessage = "You need " +
                    (building.getPrice() * player.getPriceCoefficient() - player.getMoney()) +
                    " more money to purchase " + buildingType;
        }

        if (errorMessage != null) {
            PlaceBuildingOutputData placeBuildingOutputData = new PlaceBuildingOutputData(errorMessage);
            placeBuildingOutputPresenter.prepareFailView(placeBuildingOutputData);
            return;
        }

        board.placePiece(x, y, building);
        placeBuildingDataAccessObject.addUnit(building);
        player.addBuilding(building);
        player.setMoney(player.getMoney() - (int) (building.getPrice() * player.getPriceCoefficient()));
        PlaceBuildingOutputData placeBuildingOutputData =
                new PlaceBuildingOutputData(buildingType + " is successfully placed.");
        placeBuildingOutputPresenter.prepareSuccessView(placeBuildingOutputData);

    }
}
