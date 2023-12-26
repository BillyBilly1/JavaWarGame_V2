package entity.unit.combat_unit.ranged;

import entity.attack_strategy.AttackStrategy;
import entity.attack_strategy.NormalRangedAttackStrategy;
import entity.unit.combat_unit.CombatUnit;

public class Archer extends CombatUnit {

    private static final float defaultMaxHp = 14.0f;

    private static final float defaultAttack = 6.0f;

    private static final float defaultDefense = 0.0f;

    private static final int defaultMaxOperationNum = 2;

    private static final int defaultAttackRange = 3;

    private static final int[][] defaultDamageRange = new int[][]{{0, 0}};

    private static final int defaultPrice = 164;

    private static final int defaultFoodConsumption = 10;

    private static final String iconPath = "src/icon/Archer.png";

    private static final String flippedIconPath = "src/icon/FlippedArcher.png";

    private static final AttackStrategy attackStrategy = new NormalRangedAttackStrategy();

    public Archer(int x, int y, boolean Left){
        super(x, y, Left, defaultMaxHp, defaultAttack, defaultDefense,
                defaultMaxOperationNum, defaultAttackRange, defaultDamageRange,
                defaultPrice, defaultFoodConsumption, iconPath, flippedIconPath, attackStrategy);
    }
}
