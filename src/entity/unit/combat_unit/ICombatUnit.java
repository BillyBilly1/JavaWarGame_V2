package entity.unit.combat_unit;

import entity.attack_strategy.AttackStrategy;
import entity.unit.IUnit;

public interface ICombatUnit {
    float getMaxHp();

    float getHp();

    void setHp(float hp);

    float getAttack();

    float getDefense();

    float getAtkBuff();

    void setAtkBuff(float atkBuff);

    float getDefBuff();

    void setDefBuff(float defBuff);

    int getMaxOperationNum();

    int getOperationNum();

    void setOperationNum(int operationNum);

    int getAttackRange();

    int[][] getDamageRange();

    int getPrice();

    int getFoodConsumption();

    int getHeight();

    AttackStrategy getAttackStrategy();

    int getCombatValue();

    void reset();
}
