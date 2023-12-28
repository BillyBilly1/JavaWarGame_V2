package domain.entity.unit;

import java.lang.reflect.InvocationTargetException;

public interface IUnitFactory {

    IUnit createUnit(String unitType, int x, int y, boolean left) throws
            InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;
}
