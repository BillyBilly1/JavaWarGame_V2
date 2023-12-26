package entity.unit.combat_unit;

import entity.attack_strategy.AttackStrategy;
import entity.unit.Unit;

public abstract class CombatUnit extends Unit implements ICombatUnit{

    protected final float maxHp;

    protected float hp;

    protected final float attack;

    protected final float defense;

    protected float atkBuff = 0.0f;

    protected float defBuff = 0.0f;

    protected final int maxOperationNum;

    protected int operationNum;

    protected final int attackRange;

    protected final int[][] damageRange;

    protected final int price;

    protected final int foodConsumption;

    protected final int height = 1;

    protected final AttackStrategy attackStrategy;

    protected int combatValue;

    public CombatUnit(int x, int y, boolean left, float maxHp, float attack,
                      float defense, int maxOperationNum, int attackRange,
                      int[][] damageRange, int price, int foodConsumption,
                      String iconPath, String flippedIconPath, AttackStrategy attackStrategy) {
        super(x, y, iconPath, flippedIconPath, left);
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.maxOperationNum = maxOperationNum;
        this.operationNum = maxOperationNum;
        this.attackRange = attackRange;
        this.damageRange = damageRange;
        this.price = price;
        this.foodConsumption = foodConsumption;
        this.attackStrategy = attackStrategy;
    }

    @Override
    public float getMaxHp() {
        return maxHp;
    }

    @Override
    public float getHp() {
        return hp;
    }

    @Override
    public void setHp(float hp) {
        if (hp < 0) {
            throw new IllegalArgumentException("Input value must be greater than 0");
        }
        else {this.hp = hp;}
    }

    @Override
    public float getAttack() {
        return attack;
    }

    @Override
    public float getDefense() {
        return defense;
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
    public float getDefBuff() {
        return defBuff;
    }

    @Override
    public void setDefBuff(float defBuff) {
        this.defBuff = defBuff;
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
    public void setOperationNum(int operationNum) {
        if (operationNum < 0) {
            throw new IllegalArgumentException("Input value must be greater than 0");
        }
        else {this.operationNum = operationNum;}
    }

    @Override
    public int getAttackRange() {
        return attackRange;
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
    public int getPrice() {
        return price;
    }

    @Override
    public int getFoodConsumption() {
        return foodConsumption;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public AttackStrategy getAttackStrategy() {
        return attackStrategy;
    }

    @Override
    public int getCombatValue() {
        double adjustedHp = Math.max(hp, 1);
        double normalizedHp  = adjustedHp / maxHp;
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

