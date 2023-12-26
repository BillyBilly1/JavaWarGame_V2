package entity.unit.combat_unit.melee;

import entity.attack_strategy.AttackStrategy;
import entity.attack_strategy.MeleeAttackStrategy;
import entity.unit.combat_unit.CombatUnit;

public class SpearGuard extends CombatUnit {

    private static final float defaultMaxHp = 16.0f;

    private static final float defaultAttack = 5.0f;

    private static final float defaultDefense = 0.0f;

    private static final int defaultMaxOperationNum = 2;

    private static final int defaultAttackRange = 1;

    private static final int[][] defaultDamageRange = new int[][]{{0, 0}};

    private static final int defaultPrice = 104;

    private static final int defaultFoodConsumption = 9;

    private static final String iconPath = "src/icon/SpearGuard.png";

    private static final String flippedIconPath = "src/icon/FlippedSpearGuard.png";

    private static final AttackStrategy attackStrategy = new MeleeAttackStrategy();

    public SpearGuard(int x, int y, boolean Left){
        super(x, y, Left, defaultMaxHp, defaultAttack, defaultDefense,
                defaultMaxOperationNum, defaultAttackRange, defaultDamageRange,
                defaultPrice, defaultFoodConsumption, iconPath, flippedIconPath, attackStrategy);
    }
}
