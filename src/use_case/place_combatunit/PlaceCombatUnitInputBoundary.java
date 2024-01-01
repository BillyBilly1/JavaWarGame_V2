package use_case.place_combatunit;

import java.lang.reflect.InvocationTargetException;

public interface PlaceCombatUnitInputBoundary {
    void execute(PlaceCombatUnitInputData placeCombatUnitInputData) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;
}
