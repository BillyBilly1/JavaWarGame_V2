package domain.entity.unit;

import all_class.AllClassList;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class UnitFactory implements IUnitFactory {
    private static final Map<String, Class<? extends IUnit>> registeredUnits = new HashMap<>();

    static {
        for (Class<? extends IUnit> clazz : AllClassList.getUnitClassList()) {
            registerUnit(clazz);
        }
    }

    private static void registerUnit(Class<? extends IUnit> unitClass) {
        registeredUnits.put(unitClass.getName(), unitClass);
    }

    @Override
    public IUnit createUnit(String unitType, int x, int y, boolean left) throws
            InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Class<? extends IUnit> unitClass = registeredUnits.get(unitType);
        if (unitClass == null) {
            throw new IllegalArgumentException("Unit type not registered.");
        }
        Constructor<? extends IUnit> constructor = unitClass.getConstructor(int.class, int.class, boolean.class);
        return constructor.newInstance(x, y, left);
    }
}
