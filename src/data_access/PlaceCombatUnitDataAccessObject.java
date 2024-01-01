package data_access;

import database.board.BoardRepositoryInterface;
import database.player.PlayerRepositoryInterface;
import database.unit.UnitRepositoryInterface;
import domain.entity.Player.IPlayer;
import domain.entity.board.IBoard;
import domain.entity.unit.combat_unit.ICombatUnit;
import use_case.place_combatunit.PlaceCombatUnitDataAccessInterface;

public class PlaceCombatUnitDataAccessObject implements PlaceCombatUnitDataAccessInterface {

    private final UnitRepositoryInterface unitRepository;

    private final PlayerRepositoryInterface playerRepository;

    private final BoardRepositoryInterface boardRepository;

    public PlaceCombatUnitDataAccessObject(UnitRepositoryInterface unitRepository,
                                           PlayerRepositoryInterface playerRepository,
                                           BoardRepositoryInterface boardRepository) {
        this.unitRepository = unitRepository;
        this.playerRepository = playerRepository;
        this.boardRepository = boardRepository;
    }

    @Override
    public void addUnit(ICombatUnit combatUnit) {
        unitRepository.addUnit(combatUnit);
    }

    @Override
    public IPlayer loadPlayer(boolean left) {
        return playerRepository.loadPlayer(left);
    }

    @Override
    public IBoard loadBoard() {
        return boardRepository.loadBoard();
    }
}
