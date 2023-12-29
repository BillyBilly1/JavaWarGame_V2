package data_access.unit;

import domain.entity.unit.IUnit;

import java.util.Collection;

public interface UnitDataAccessInterface {

    void addUnit(IUnit unit);

    void removeUnit(String id);

    IUnit getUnit(String id);

    Collection<IUnit> getAllUnits();
}

