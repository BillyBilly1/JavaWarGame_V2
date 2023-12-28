package domain.entity.Player;

import domain.entity.item.Item;
import domain.entity.unit.building.IBuilding;
import domain.entity.unit.combat_unit.ICombatUnit;

import java.util.ArrayList;

public interface IPlayer {

    String getName();

    boolean isLeft();

    ArrayList<ICombatUnit> getCombatUnitList();

    ArrayList<IBuilding> getBuildingList();

    ArrayList<Item> getItemList();

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

    int getFrontLinePositionX(int boardWidth);

    int getTotalOperationNum();

    int getTotalFoodConsumption();
}