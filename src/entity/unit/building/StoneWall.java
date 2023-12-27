package entity.unit.building;

import entity.attack_strategy.AttackStrategy;
import entity.attack_strategy.NormalRangedAttackStrategy;

public class StoneWall extends Building{

    private static final float defaultMaxHp = 25.0f;

    private static final float defaultDefense = 1.0f;

    private static final int defaultPrice = 160;

    private static final int defaultMaintenanceFee = 10;

    private static final int defaultHeight = 2;

    private static final float defaultKillRewardMultiplier = 0.4f;

    private static final String iconPath = "src/icon/original/StoneWall.PNG";

    private static final String flippedIconPath = "src/icon/flipped/FlippedStoneWall.PNG";


    public StoneWall(int x, int y, boolean left){
        super(x, y, left, defaultMaxHp, defaultDefense, defaultPrice,
                defaultMaintenanceFee, defaultHeight, defaultKillRewardMultiplier,
                iconPath, flippedIconPath);
    }
}
