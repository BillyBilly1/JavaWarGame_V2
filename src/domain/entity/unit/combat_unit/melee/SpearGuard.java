package domain.entity.unit.combat_unit.melee;
import domain.attack_strategy.AttackStrategy;
import domain.attack_strategy.MeleeAttackStrategy;
import domain.entity.OperationNumConstant;
import domain.entity.RangeConstant;
import domain.entity.unit.combat_unit.CombatUnit;

public class SpearGuard extends CombatUnit {

    private static final float defaultMaxHp = 16.0f;

    private static final float defaultAttack = 5.0f;

    private static final float defaultDefense = 0.0f;

    private static final int defaultMaxOperationNum = 4;

    private static final int defaultAttackOperationNumCost = OperationNumConstant.meleeAttackOpCost;

    private static final int[][] defaultAttackRange = RangeConstant.meleeAttackRange;

    private static final int[][] defaultDamageRange = RangeConstant.normalDamageRange;

    private static final int defaultPrice = 104;

    private static final int defaultFoodConsumption = 9;

    private static final String iconPath = "src/icon/original/SpearGuard.PNG";

    private static final String flippedIconPath = "src/icon/flipped/FlippedSpearGuard.PNG";

    private static final AttackStrategy attackStrategy = new MeleeAttackStrategy();

    public SpearGuard(int x, int y, boolean Left, String id){
        super(x, y, Left, id, defaultMaxHp, defaultAttack, defaultDefense,
                defaultMaxOperationNum, defaultAttackOperationNumCost, defaultAttackRange, defaultDamageRange,
                defaultPrice, defaultFoodConsumption, iconPath, flippedIconPath, attackStrategy);
    }
}
