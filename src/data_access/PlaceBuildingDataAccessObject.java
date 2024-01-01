package data_access;

import database.board.BoardRepositoryInterface;
import database.player.PlayerRepositoryInterface;
import database.unit.UnitRepositoryInterface;
import domain.entity.Player.IPlayer;
import domain.entity.board.IBoard;
import domain.entity.unit.building.IBuilding;
import use_case.place_building.PlaceBuildingDataAccessInterface;

public class PlaceBuildingDataAccessObject implements PlaceBuildingDataAccessInterface {

    private final UnitRepositoryInterface unitRepository;

    private final PlayerRepositoryInterface playerRepository;

    private final BoardRepositoryInterface boardRepository;


    public PlaceBuildingDataAccessObject(UnitRepositoryInterface unitRepository, PlayerRepositoryInterface playerRepository, BoardRepositoryInterface boardRepository) {
        this.unitRepository = unitRepository;
        this.playerRepository = playerRepository;
        this.boardRepository = boardRepository;
    }

    @Override
    public void addUnit(IBuilding building) {
        unitRepository.addUnit(building);
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

