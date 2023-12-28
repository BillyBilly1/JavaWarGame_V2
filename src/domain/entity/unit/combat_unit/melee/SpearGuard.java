package domain.entity.unit.combat_unit.melee;
import domain.attack_strategy.AttackStrategy;
import domain.attack_strategy.MeleeAttackStrategy;
import domain.entity.unit.combat_unit.CombatUnit;

public class SpearGuard extends CombatUnit {

    private static final float defaultMaxHp = 16.0f;

    private static final float defaultAttack = 5.0f;

    private static final float defaultDefense = 0.0f;

    private static final int defaultMaxOperationNum = 2;

    private static final int defaultAttackRange = 1;

    private static final int[][] defaultDamageRange = new int[][]{{0, 0}};

    private static final int defaultPrice = 104;

    private static final int defaultFoodConsumption = 9;

    private static final String iconPath = "src/icon/original/SpearGuard.PNG";

    private static final String flippedIconPath = "src/icon/flipped/FlippedSpearGuard.PNG";

    private static final AttackStrategy attackStrategy = new MeleeAttackStrategy();

    public SpearGuard(int x, int y, boolean Left, String id){
        super(x, y, Left, id, defaultMaxHp, defaultAttack, defaultDefense,
                defaultMaxOperationNum, defaultAttackRange, defaultDamageRange,
                defaultPrice, defaultFoodConsumption, iconPath, flippedIconPath, attackStrategy);
    }
}
