package domain.entity.unit.building;

public class WoodenFence extends Building{

    private static final float defaultMaxHp = 15.0f;

    private static final float defaultDefense = 0.5f;

    private static final int defaultPrice = 95;

    private static final int defaultMaintenanceFee = 6;

    private static final int defaultHeight = 1;

    private static final float defaultKillRewardMultiplier = 0.6f;

    private static final String iconPath = "src/icon/original/WoodenFence.PNG";

    private static final String flippedIconPath = "src/icon/flipped/FlippedWoodenFence.PNG";


    public WoodenFence(int x, int y, boolean left, String id){
        super(x, y, left, id, defaultMaxHp, defaultDefense, defaultPrice,
                defaultMaintenanceFee, defaultHeight, defaultKillRewardMultiplier,
                iconPath, flippedIconPath);
    }
}
