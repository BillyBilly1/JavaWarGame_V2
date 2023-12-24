package entity.unit.combat_unit;

import entity.unit.Unit;

public class CombatUnit extends Unit implements ICombatUnit {
    public CombatUnit(int x, int y, boolean isLeft) {
        super(x, y, isLeft);
    }
}
