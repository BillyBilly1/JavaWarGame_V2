package entity.unit.building;

import entity.attack_strategy.AttackStrategy;
import entity.attack_strategy.NormalRangedAttackStrategy;

public class StoneWall extends Building{

    private static final float defaultMaxHp = 14.0f;

    private static final float defaultDefense = 0.0f;

    private static final int defaultPrice = 164;

    private static final int defaultMaintenanceFee = 10;

    private static final String iconPath = "src/icon/Archer.png";

    private static final String flippedIconPath = "src/icon/FlippedArcher.png";

    private static final AttackStrategy attackStrategy = new NormalRangedAttackStrategy();



    public StoneWall(int x, int y, boolean left, float maxHp, float defense, int Price, int maintenanceFee, int height, int killRewardMultiplier, String iconPath, String flippedIconPath) {
        super(x, y, left, maxHp, defense, Price, maintenanceFee, height, killRewardMultiplier, iconPath, flippedIconPath);
    }
}
