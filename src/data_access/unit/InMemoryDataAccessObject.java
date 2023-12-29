package data_access.unit;

import domain.entity.unit.IUnit;

import java.util.Collection;
import java.util.HashMap;

public class InMemoryDataAccessObject implements UnitDataAccessInterface{

    private final HashMap<String, IUnit> units = new HashMap<>();


    @Override
    public void addUnit(IUnit unit) {
        units.put(unit.getId(), unit);
    }

    @Override
    public void removeUnit(String id) {
        units.remove(id);
    }

    @Override
    public IUnit getUnit(String id) {
        return units.get(id);
    }

    @Override
    public Collection<IUnit> getAllUnits() {
        return units.values();
    }
}
