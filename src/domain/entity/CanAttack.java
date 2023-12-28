package domain.entity;

import domain.attack_strategy.AttackStrategy;

public interface CanAttack {

    float getAttack();

    float getAtkBuff();

    void setAtkBuff(float atkBuff);

    int getAttackRange();

    int[][] getDamageRange();

    int getMaxOperationNum();

    int getOperationNum();

    void setOperationNum(int operationNum);

    AttackStrategy getAttackStrategy();

}
