package entity.unit.combat_unit.melee;

import entity.attack_strategy.AttackStrategy;
import entity.attack_strategy.MeleeAttackStrategy;
import entity.unit.combat_unit.CombatUnit;

public class LanceKnight extends CombatUnit {

    private static final float defaultMaxHp = 22.0f;

    private static final float defaultAttack = 9.0f;

    private static final float defaultDefense = 0.5f;

    private static final int defaultMaxOperationNum = 4;

    private static final int defaultAttackRange = 1;

    private static final int[][] defaultDamageRange = new int[][]{{0, 0}};

    private static final int defaultPrice = 442;

    private static final int defaultFoodConsumption = 32;

    private static final String iconPath = "src/icon/original/LanceKnight.PNG";

    private static final String flippedIconPath = "src/icon/flipped/FlippedLanceKnight.png";

    private static final AttackStrategy attackStrategy = new MeleeAttackStrategy();

    public LanceKnight(int x, int y, boolean Left){
        super(x, y, Left, defaultMaxHp, defaultAttack, defaultDefense,
                defaultMaxOperationNum, defaultAttackRange, defaultDamageRange,
                defaultPrice, defaultFoodConsumption, iconPath, flippedIconPath, attackStrategy);
    }
}
