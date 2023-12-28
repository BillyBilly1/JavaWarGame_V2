package domain.entity.unit.building;

import domain.entity.unit.Unit;

public abstract class Building extends Unit implements IBuilding{

    protected final int maintenanceFee;

    public Building(int x, int y,  boolean left, float maxHp, float defense,
                    int Price, int maintenanceFee, int height, float killRewardMultiplier,
                    String iconPath, String flippedIconPath) {
        super(x, y, left, maxHp, defense, Price, height,
                killRewardMultiplier, iconPath, flippedIconPath);
        this.maintenanceFee = maintenanceFee;
    }

    @Override
    public int getMaintenanceFee() {
        return this.maintenanceFee;
    }

    @Override
    public int getStrength() {
        double adjustedHp = Math.max(hp, 0);
        double normalizedHp  = adjustedHp / maxHp;
        double hpEffect = Math.sqrt(normalizedHp);
        return (int) (0.6 * hpEffect * price);
    }
}
