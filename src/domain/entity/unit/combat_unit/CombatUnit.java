package domain.entity.unit.combat_unit;

import domain.entity.CanAttack;
import domain.attack_strategy.AttackStrategy;
import domain.entity.unit.Unit;

public abstract class CombatUnit extends Unit implements ICombatUnit, CanAttack {

    protected final float attack;

    protected float atkBuff = 0.0f;

    protected final int maxOperationNum;

    protected int operationNum;

    protected int attackOperationNumCost;

    protected final int[][] attackRange;

    protected final int[][] damageRange;

    protected final int foodConsumption;

    protected static final int defaultHeight = 1;

    protected static final float defaultKillRewardMultiplier = 0.5f;

    protected final AttackStrategy attackStrategy;

    public CombatUnit(int x, int y, boolean left, String id, float maxHp, float attack,
                      float defense, int maxOperationNum, int attackOperationNumCost, int[][] attackRange,
                      int[][] damageRange, int price, int foodConsumption,
                      String iconPath, String flippedIconPath, AttackStrategy attackStrategy) {
        super(x, y, left, id,  maxHp, defense, price, defaultHeight,
                defaultKillRewardMultiplier, iconPath, flippedIconPath);
        this.attack = attack;
        this.maxOperationNum = maxOperationNum;
        this.operationNum = maxOperationNum;
        this.attackOperationNumCost = attackOperationNumCost;
        this.attackRange = attackRange;
        this.damageRange = damageRange;
        this.foodConsumption = foodConsumption;
        this.attackStrategy = attackStrategy;
    }

    @Override
    public float getAttack() {
        return attack;
    }

    @Override
    public float getAtkBuff() {
        return atkBuff;
    }

    @Override
    public void setAtkBuff(float atkBuff) {
        this.atkBuff = atkBuff;
    }

    @Override
    public float getStaminaBasedAttackDebuff() {

        float operationEfficiency = 1 - (float) operationNum / attackOperationNumCost;
        float attackDebuff = - attack * 0.4f * operationEfficiency;
        attackDebuff = Math.round(attackDebuff * 10) / 10.0f;
        if (hp < 1) {
            attackDebuff = - attack + 1;
        }
        return attackDebuff;
    }

    @Override
    public int getMaxOperationNum() {
        return maxOperationNum;
    }

    @Override
    public int getOperationNum() {
        return operationNum;
    }

    @Override
    public int getAttackOperationNumCost() {return attackOperationNumCost; }

    @Override
    public void setOperationNum(int operationNum) {
        if (operationNum < 0) {
            throw new IllegalArgumentException("operationNum must be greater than 0");
        }
        else if (operationNum > maxOperationNum) {
            throw new IllegalArgumentException("operationNum must be smaller than maxOperationNum");
        }
        else {this.operationNum = operationNum;}
    }

    @Override
    public int[][] getAttackRange() {
        return attackRange;
    }

    @Override
    public int[][] getCurrentAttackRange() {
        int resultLength = attackRange.length;
        int[][] resultArray = new int[resultLength][2];
        for (int i = 0; i < resultLength; i++) {
            resultArray[i][0] = attackRange[i][0] + x;
            resultArray[i][1] = attackRange[i][1] + y;
        }
        return resultArray;
    }

    @Override
    public int[][] getDamageRange() {
        // return a copied damageRange to avoid client code mutating the damageRange
        return copy2DArray(damageRange);
    }

    private int[][] copy2DArray(int[][] original) {
        if (original == null) {
            return null;
        }
        int[][] copy = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }


    @Override
    public int getFoodConsumption() {
        return foodConsumption;
    }

    @Override
    public AttackStrategy getAttackStrategy() {
        return attackStrategy;
    }

    @Override
    public int getStrength() {
        double adjustedHp = Math.max(hp, 0);
        double normalizedHp  = adjustedHp / maxHp;
        // Calculate hpEffect, which is the combined result of square root and cubic function,
        // each multiplied by their respective coefficients.
        // When normalizedHp = 1, hpEffect equals 1 as Math.sqrt(1) = 1 and Math.pow(1, 3) = 1.
        double hpEffect = 0.7 * Math.sqrt(normalizedHp) + 0.3 * Math.pow(normalizedHp, 3);
        return (int) hpEffect * price;
    }

    @Override
    public void reset() {
        setOperationNum(0);
        setAtkBuff(0);
        setDefBuff(0);
    }
}

