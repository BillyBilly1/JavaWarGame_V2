package use_case.place_combatunit;

import use_case.place_terrain.PlaceTerrainOutputData;

public interface PlaceCombatUnitOutputBoundary {
    void prepareSuccessView(PlaceCombatUnitOutputData placeCombatUnitOutputData);

    void prepareFailView(PlaceCombatUnitOutputData placeCombatUnitOutputData);
}
