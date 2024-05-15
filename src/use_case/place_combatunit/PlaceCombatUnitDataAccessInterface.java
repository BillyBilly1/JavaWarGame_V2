package use_case.place_combatunit;

import domain.entity.Player.IPlayer;
import domain.entity.board.IBoard;
import domain.entity.unit.combat_unit.ICombatUnit;

public interface PlaceCombatUnitDataAccessInterface {

    void addUnit(ICombatUnit CombatUnit);

    IPlayer loadPlayer(boolean left);

    IBoard loadBoard();
}
