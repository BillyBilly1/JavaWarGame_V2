package domain.entity.Player;

import domain.entity.item.Item;
import domain.entity.unit.building.IBuilding;
import domain.entity.unit.combat_unit.ICombatUnit;

import java.util.List;

public interface IPlayer {

    String getName();

    boolean isLeft();

    List<ICombatUnit> getCombatUnitList();

    List<IBuilding> getBuildingList();

    List<Item> getItemList();

    void addCombatUnit(ICombatUnit combatUnit);

    void removeCombatUnit(ICombatUnit combatUnit);

    void addBuilding(IBuilding building);

    void removeBuilding(IBuilding building);

    void addItem(Item item);

    void removeItem(Item item);

    int getMoney();

    void setMoney(int money);

    int getFoodAmount();

    void setFoodAmount(int foodAmount);

    int getOverallStrengthRating();

    int getStarvationDuration();

    void setStarvationDuration(int starvationDuration);

    int getTotalEnemyStrengthDefeated();

    void setTotalEnemyStrengthDefeated(int totalEnemyStrengthDefeated);

    float getPriceCoefficient();

    void setPriceCoefficient(float priceCoefficient);

    int getFrontLinePositionX(int boardWidth);

    int[] getPlacementRangeForHeight1(int boardWidth);

    int[] getPlacementRangeForHeight2(int boardWidth);

    boolean canPlaceUnitAt(int x, int height, int boardWidth);

    int getTotalOperationNum();

    int getTotalFoodConsumption();

    boolean isLost();
}
