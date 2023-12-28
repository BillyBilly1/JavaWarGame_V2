package domain.entity.unit.combat_unit;

import domain.attack_strategy.AttackStrategy;
import domain.entity.unit.IUnit;

public interface ICombatUnit extends IUnit {

    float getAttack();

    float getAtkBuff();

    void setAtkBuff(float atkBuff);

    int getMaxOperationNum();

    int getOperationNum();

    void setOperationNum(int operationNum);

    int getAttackRange();

    int[][] getDamageRange();

    int getFoodConsumption();

    AttackStrategy getAttackStrategy();

    void reset();
}
