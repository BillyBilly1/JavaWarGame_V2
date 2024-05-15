package domain.entity.unit.combat_unit;

import domain.attack_strategy.AttackStrategy;
import domain.entity.CanAttack;
import domain.entity.unit.IUnit;

public interface ICombatUnit extends IUnit, CanAttack {

    float getAttack();

    float getAtkBuff();

    void setAtkBuff(float atkBuff);

    float getStaminaBasedAttackDebuff();

    int getMaxOperationNum();

    int getOperationNum();

    int getAttackOperationNumCost();

    void setOperationNum(int operationNum);

    int[][] getAttackRange();

    int[][] getCurrentAttackRange();

    int[][] getDamageRange();

    int getFoodConsumption();

    AttackStrategy getAttackStrategy();

    void reset();
}
