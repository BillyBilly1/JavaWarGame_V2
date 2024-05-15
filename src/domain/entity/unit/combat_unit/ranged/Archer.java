package domain.entity.unit.combat_unit.ranged;

import domain.attack_strategy.AttackStrategy;
import domain.attack_strategy.NormalRangedAttackStrategy;
import domain.entity.RangeConstant;
import domain.entity.unit.combat_unit.CombatUnit;

public class Archer extends CombatUnit {

    private static final float defaultMaxHp = 14.0f;

    private static final float defaultAttack = 6.0f;

    private static final float defaultDefense = 0.0f;

    private static final int defaultMaxOperationNum = 2;

    private static final int[][] defaultAttackRange = RangeConstant.threeCellRangedAttackRange;

    private static final int[][] defaultDamageRange = RangeConstant.normalDamageRange;

    private static final int defaultPrice = 164;

    private static final int defaultFoodConsumption = 10;

    private static final String iconPath = "src/icon/original/Archer.PNG";

    private static final String flippedIconPath = "src/icon/flipped/FlippedArcher.PNG";

    private static final AttackStrategy attackStrategy = new NormalRangedAttackStrategy();

    public Archer(int x, int y, boolean Left, String id){
        super(x, y, Left, id, defaultMaxHp, defaultAttack, defaultDefense,
                defaultMaxOperationNum, defaultAttackRange, defaultDamageRange,
                defaultPrice, defaultFoodConsumption, iconPath, flippedIconPath, attackStrategy);
    }
}
