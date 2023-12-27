package entity.Player;

import entity.item.Item;
import entity.unit.building.IBuilding;
import entity.unit.combat_unit.CombatUnit;
import entity.unit.combat_unit.ICombatUnit;

import java.util.ArrayList;

public class Player implements IPlayer{

    private final String name;

    private final boolean left;

    private final ArrayList<ICombatUnit> combatUnitList = new ArrayList<>();

    private final ArrayList<IBuilding> buildingList = new ArrayList<>();

    private final ArrayList<Item> itemList = new ArrayList<>();

    private int money;

    private int foodAmount;

    private int totalEnemyStrengthDefeated = 0;


    public Player(String name, boolean left, int money, int foodAmount) {
        this.name = name;
        this.left = left;
        this.money = money;
        this.foodAmount = foodAmount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isLeft() {
        return left;
    }

    @Override
    public ArrayList<ICombatUnit> getCombatUnitList() {
        return combatUnitList;
    }

    @Override
    public ArrayList<IBuilding> getBuildingList() {
        return buildingList;
    }

    @Override
    public ArrayList<Item> getItemList() {
        return itemList;
    }

    @Override
    public void addCombatUnit(ICombatUnit combatUnit) {
        if (combatUnit != null) {
            combatUnitList.add(combatUnit);
        }
    }

    @Override
    public void removeCombatUnit(ICombatUnit combatUnit) {
        combatUnitList.remove(combatUnit);
    }

    @Override
    public void addBuilding(IBuilding building) {
        if (building != null) {
            buildingList.add(building);
        }
    }

    @Override
    public void removeBuilding(IBuilding building) {
        buildingList.remove(building);
    }

    @Override
    public void addItem(Item item) {
        if (item != null) {
            itemList.add(item);
        }
    }

    @Override
    public void removeItem(Item item) {
        itemList.remove(item);
    }

    @Override
    public int getMoney() {
        return money;
    }

    @Override
    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public int getFoodAmount() {
        return foodAmount;
    }

    @Override
    public void setFoodAmount(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    @Override
    public int getOverallStrengthRating() {
        int overallStrengthRating = 0;
        for (ICombatUnit combatUnit : combatUnitList) {
            overallStrengthRating += combatUnit.getStrength();
        }
        for (IBuilding building : buildingList) {
            overallStrengthRating += building.getStrength();
        }
        return overallStrengthRating;
    }

    @Override
    public int getTotalEnemyStrengthDefeated() {
        return totalEnemyStrengthDefeated;
    }

    @Override
    public void setTotalEnemyStrengthDefeated(int totalEnemyStrengthDefeated) {
        this.totalEnemyStrengthDefeated = totalEnemyStrengthDefeated;
    }

    /**
     * Calculates the front line position on the game board.
     * The front line is positioned between 1/5 and 4/5 of the board's length for both players,
     * taking account of 5 grids behind the most front combatUnit
     *
     * @param boardWidth The length of the game board.
     * @return The calculated front line position.
     */
    @Override
    public int getFrontLinePositionX(int boardWidth) {
        int oneFifthLength = boardWidth / 5;
        int fourFifthsLength = boardWidth - oneFifthLength;
        int frontLinePositionX = 0;
        if (left) {
            for (ICombatUnit combatUnit : combatUnitList) {
                frontLinePositionX = Math.max(combatUnit.getX(), frontLinePositionX);
            }
        }
        else {
            for (ICombatUnit combatUnit : combatUnitList) {
                frontLinePositionX = Math.min(combatUnit.getX(), frontLinePositionX);
            }
        }
        return left ? Math.min(Math.max(frontLinePositionX, oneFifthLength), fourFifthsLength)
                : Math.max(Math.min(frontLinePositionX, fourFifthsLength), oneFifthLength);
    }
}