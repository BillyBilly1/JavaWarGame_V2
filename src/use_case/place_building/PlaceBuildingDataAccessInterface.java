package use_case.place_building;

import domain.entity.Player.IPlayer;
import domain.entity.board.IBoard;
import domain.entity.unit.building.IBuilding;

public interface PlaceBuildingDataAccessInterface {
    void addUnit(IBuilding building);

    IPlayer loadPlayer(boolean left);

    IBoard loadBoard();
}
