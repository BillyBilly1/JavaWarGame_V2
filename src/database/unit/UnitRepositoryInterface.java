package database.unit;

import domain.entity.unit.IUnit;

import java.util.Collection;

public interface UnitRepositoryInterface {

    void addUnit(IUnit unit);

    void removeUnit(String id);

    IUnit getUnit(String id);

    Collection<IUnit> getAllUnits();
}

