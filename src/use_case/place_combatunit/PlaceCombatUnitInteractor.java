package use_case.place_combatunit;

import domain.entity.Player.IPlayer;
import domain.entity.board.IBoard;
import domain.entity.unit.IUnitFactory;
import domain.entity.unit.combat_unit.ICombatUnit;
import exception.InvalidPlacementException;
import exception.TileOccupiedException;

import java.lang.reflect.InvocationTargetException;

public class PlaceCombatUnitInteractor implements PlaceCombatUnitInputBoundary{

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
        // For explanation, refer to that in PlaceTerrainInteractor
        if (!board.isOccupied(x, y)) {
            try {
                // Create the combatUnit and put it onto the board and into the user's combatUnit list
                ICombatUnit combatUnit = (ICombatUnit) unitFactory.createUnit(combatUnitType, x, y, left);
                board.placePiece(x, y, combatUnit);
                IPlayer player = placeCombatUnitDataAccessObject.loadPlayer(left);
                player.addCombatUnit(combatUnit, board.getWidth());

                PlaceCombatUnitOutputData placeCombatUnitOutputData =
                        new PlaceCombatUnitOutputData(combatUnitType + " is successfully placed.");
                placeCombatUnitOutputPresenter.prepareSuccessView(placeCombatUnitOutputData);
            } catch (TileOccupiedException | InvalidPlacementException e) {
                PlaceCombatUnitOutputData placeCombatUnitOutputData =
                        new PlaceCombatUnitOutputData(e.getMessage());
                placeCombatUnitOutputPresenter.prepareFailView(placeCombatUnitOutputData);
            }
        }
        else {
            String message = "Position at (" + x + ", " + y + ") is already occupied.";
            placeCombatUnitOutputPresenter.prepareFailView(new PlaceCombatUnitOutputData(message));
        }
    }
}