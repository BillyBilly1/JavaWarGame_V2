package domain.entity.Player;

import domain.entity.CanAttack;
import domain.entity.item.Item;
import domain.entity.unit.building.IBuilding;
import domain.entity.unit.combat_unit.ICombatUnit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player implements IPlayer {

    private final String name;

    private final boolean left;

    private final ArrayList<ICombatUnit> combatUnitList = new ArrayList<>();

    private final ArrayList<IBuilding> buildingList = new ArrayList<>();

    private final ArrayList<Item> itemList = new ArrayList<>();

    private int money;

    private int foodAmount;

    private int starvationDuration = 0;

    private int totalEnemyStrengthDefeated = 0;

    private float priceCoefficient = 1;


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
    public List<ICombatUnit> getCombatUnitList() {
        return Collections.unmodifiableList(combatUnitList);
    }

    @Override
    public List<IBuilding> getBuildingList() {
        return Collections.unmodifiableList(buildingList);
    }

    @Override
    public List<Item> getItemList() {
        return Collections.unmodifiableList(itemList);
    }

    @Override
    public void addCombatUnit(ICombatUnit combatUnit) {
        combatUnitList.add(combatUnit);

    }

    @Override
    public void removeCombatUnit(ICombatUnit combatUnit) {
        combatUnitList.remove(combatUnit);
    }

    @Override
    public void addBuilding(IBuilding building) {
        buildingList.add(building);
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
        overallStrengthRating += (int) (money + 0.5 * foodAmount);
        return overallStrengthRating;
    }

    @Override
    public int getStarvationDuration() {
        return starvationDuration;
    }

    @Override
    public void setStarvationDuration(int starvationDuration) {
        this.starvationDuration = starvationDuration;
    }

    @Override
    public int getTotalEnemyStrengthDefeated() {
        return totalEnemyStrengthDefeated;
    }

    @Override
    public void setTotalEnemyStrengthDefeated(int totalEnemyStrengthDefeated) {
        this.totalEnemyStrengthDefeated = totalEnemyStrengthDefeated;
    }

    @Override
    public float getPriceCoefficient() {
        return priceCoefficient;
    }

    @Override
    public void setPriceCoefficient(float priceCoefficient) {
        this.priceCoefficient = priceCoefficient;
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
        } else {
            for (ICombatUnit combatUnit : combatUnitList) {
                frontLinePositionX = Math.min(combatUnit.getX(), frontLinePositionX);
            }
        }
        return left ? Math.min(Math.max(frontLinePositionX, oneFifthLength), fourFifthsLength)
                : Math.max(Math.min(frontLinePositionX, fourFifthsLength), oneFifthLength);
    }

    /**
     * Calculates the valid placement range for units with height 1.
     *
     * @param boardWidth The width of the game board.
     * @return An int array containing the start and end positions where units can be placed.
     */
    @Override
    public int[] getPlacementRangeForHeight1(int boardWidth) {
        int oneFifthLength = boardWidth / 5;
        int fourFifthsLength = boardWidth - oneFifthLength;
        int frontLinePositionX = getFrontLinePositionX(boardWidth);

        int start = left ? oneFifthLength : frontLinePositionX - 5;
        int end = left ? frontLinePositionX + 5 : fourFifthsLength;

        // Ensuring the start and end are within the board bounds
        start = Math.max(start, 0);
        end = Math.min(end, boardWidth - 1);

        return new int[]{start, end};
    }

    /**
     * Calculates the valid placement range for units with height 2.
     *
     * @param boardWidth The width of the game board.
     * @return An int array containing the start and end positions where units can be placed.
     */
    @Override
    public int[] getPlacementRangeForHeight2(int boardWidth) {
        int oneFifthLength = boardWidth / 5;
        int start, end;

        if (left) {
            start = 0;
            end = oneFifthLength;
        } else {
            start = boardWidth - oneFifthLength;
            end = boardWidth - 1;
        }

        return new int[]{start, end};
    }

    /**
     * Determines if a unit can be placed at a specific position.
     *
     * @param x          The x-coordinate on the game board.
     * @param height     The height of the unit to be placed.
     * @param boardWidth The width of the game board.
     * @return true if the unit can be placed at the given position; false otherwise.
     */
    @Override
    public boolean canPlaceUnitAt(int x, int height, int boardWidth) {
        if (height == 1) {
            int[] range = getPlacementRangeForHeight1(boardWidth);
            return x >= range[0] && x <= range[1];
        } else if (height == 2) {
            int[] range = getPlacementRangeForHeight2(boardWidth);
            return x >= range[0] && x <= range[1];
        }
        return false;
    }


    @Override
    public int getTotalOperationNum() {
        int totalOperationNum = 0;
        for (ICombatUnit combatUnit : combatUnitList) {
            totalOperationNum += combatUnit.getOperationNum();
        }
        for (IBuilding building : buildingList) {
            if (building instanceof CanAttack) {
                totalOperationNum += ((CanAttack) building).getOperationNum();
            }
        }
        return totalOperationNum;
    }

    @Override
    public int getTotalFoodConsumption() {
        int totalFoodConsumption = 0;
        for (ICombatUnit combatUnit : combatUnitList) {
            totalFoodConsumption += combatUnit.getFoodConsumption();
        }
        return totalFoodConsumption;
    }

    public boolean isLost() {
        if (combatUnitList.isEmpty()) {
            return true;
        }
        else {return false;}
    }
}