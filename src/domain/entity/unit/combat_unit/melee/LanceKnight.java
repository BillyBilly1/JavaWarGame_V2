package domain.entity.unit.combat_unit.melee;

import domain.attack_strategy.AttackStrategy;
import domain.attack_strategy.MeleeAttackStrategy;
import domain.entity.OperationNumConstant;
import domain.entity.RangeConstant;
import domain.entity.unit.combat_unit.CombatUnit;

public class LanceKnight extends CombatUnit {

    private static final float defaultMaxHp = 22.0f;

    private static final float defaultAttack = 9.0f;

    private static final float defaultDefense = 0.5f;

    private static final int defaultMaxOperationNum = 7;

    private static final int defaultAttackOperationNumCost = OperationNumConstant.mountedCombatOpCost;

    private static final int[][] defaultAttackRange = RangeConstant.meleeAttackRange;

    private static final int[][] defaultDamageRange = RangeConstant.normalDamageRange;

    private static final int defaultPrice = 442;

    private static final int defaultFoodConsumption = 32;

    private static final String iconPath = "src/icon/original/LanceKnight.PNG";

    private static final String flippedIconPath = "src/icon/flipped/FlippedLanceKnight.png";

    private static final AttackStrategy attackStrategy = new MeleeAttackStrategy();

    public LanceKnight(int x, int y, boolean Left, String id){
        super(x, y, Left, id, defaultMaxHp, defaultAttack, defaultDefense,
                defaultMaxOperationNum, defaultAttackOperationNumCost, defaultAttackRange, defaultDamageRange,
                defaultPrice, defaultFoodConsumption, iconPath, flippedIconPath, attackStrategy);
    }
}
