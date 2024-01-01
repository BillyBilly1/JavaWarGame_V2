package use_case.place_combatunit;

import domain.entity.Player.IPlayer;
import domain.entity.board.IBoard;
import domain.entity.unit.IUnitFactory;
import domain.entity.unit.combat_unit.ICombatUnit;
import exception.InvalidPlacementException;
import exception.MoneyNotEnoughException;
import exception.TileOccupiedException;

import java.lang.reflect.InvocationTargetException;

public class PlaceCombatUnitInteractor implements PlaceCombatUnitInputBoundary {
    final PlaceCombatUnitDataAccessInterface placeCombatUnitDataAccessObject;
    final PlaceCombatUnitOutputBoundary placeCombatUnitOutputPresenter;
    final IUnitFactory unitFactory;

    public PlaceCombatUnitInteractor(PlaceCombatUnitDataAccessInterface placeCombatUnitDataAccessObject,
                                     PlaceCombatUnitOutputBoundary placeCombatUnitOutputPresenter,
                                     IUnitFactory unitFactory) {
        this.placeCombatUnitDataAccessObject = placeCombatUnitDataAccessObject;
        this.placeCombatUnitOutputPresenter = placeCombatUnitOutputPresenter;
        this.unitFactory = unitFactory;
    }

    @Override
    public void execute(PlaceCombatUnitInputData placeCombatUnitInputData) throws
            InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        int x = placeCombatUnitInputData.getX();
        int y = placeCombatUnitInputData.getY();
        boolean left = placeCombatUnitInputData.isLeft();
        String combatUnitType = placeCombatUnitInputData.getCombatUnitType();
        IBoard board = placeCombatUnitDataAccessObject.loadBoard();
        IPlayer player = placeCombatUnitDataAccessObject.loadPlayer(left);

        ICombatUnit combatUnit = (ICombatUnit) unitFactory.createUnit(combatUnitType, x, y, left);

        String errorMessage = null;

        if (board.isOccupied(x, y)) {
            errorMessage = "Position at (" + x + ", " + y + ") is already occupied.";
        } else if (!player.canPlaceUnitAt(x, combatUnit.getHeight(), board.getWidth())) {
            errorMessage = "Invalid placement.";
        } else if (player.getMoney() < combatUnit.getPrice() * player.getPriceCoefficient()) {
            errorMessage = "You need " +
                    (combatUnit.getPrice() * player.getPriceCoefficient() - player.getMoney()) +
                    " more money to purchase " + combatUnitType;
        }

        if (errorMessage != null) {
            PlaceCombatUnitOutputData placeCombatUnitOutputData = new PlaceCombatUnitOutputData(errorMessage);
            placeCombatUnitOutputPresenter.prepareFailView(placeCombatUnitOutputData);
            return;
        }

        board.placePiece(x, y, combatUnit);
        player.addCombatUnit(combatUnit);
        player.setMoney(player.getMoney() - (int) (combatUnit.getPrice() * player.getPriceCoefficient()));

        PlaceCombatUnitOutputData placeCombatUnitOutputData =
                new PlaceCombatUnitOutputData(combatUnitType + " is successfully placed.");
        placeCombatUnitOutputPresenter.prepareSuccessView(placeCombatUnitOutputData);
    }
}
