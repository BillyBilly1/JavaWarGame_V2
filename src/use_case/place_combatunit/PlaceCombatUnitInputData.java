package use_case.place_combatunit;

public class PlaceCombatUnitInputData {

    private final int x;

    private final int y;

    private final boolean left;

    private final String combatUnitType;

    public PlaceCombatUnitInputData(int x, int y, boolean left, String combatUnitType) {
        this.x = x;
        this.y = y;
        this.left = left;
        this.combatUnitType = combatUnitType;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isLeft() {
        return left;
    }

    public String getCombatUnitType() {
        return combatUnitType;
    }
}
