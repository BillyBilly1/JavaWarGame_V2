package domain.entity;

import domain.attack_strategy.AttackStrategy;

public interface CanAttack {

    boolean isLeft();

    float getAttack();

    float getAtkBuff();

    void setAtkBuff(float atkBuff);

    float getStaminaBasedAttackDebuff();

    int[][] getAttackRange();

    int[][] getCurrentAttackRange();

    int[][] getDamageRange();

    int getMaxOperationNum();

    int getOperationNum();

    int getAttackOperationNumCost();

    void setOperationNum(int operationNum);

    AttackStrategy getAttackStrategy();

}
