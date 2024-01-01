package use_case.place_building;

import use_case.place_combatunit.PlaceCombatUnitOutputData;

public interface PlaceBuildingOutputBoundary {
    void prepareSuccessView(PlaceBuildingOutputData placeBuildingOutputData);

    void prepareFailView(PlaceBuildingOutputData placeBuildingOutputData);
}
