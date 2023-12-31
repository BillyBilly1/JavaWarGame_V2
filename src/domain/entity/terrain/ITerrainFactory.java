package domain.entity.terrain;

import java.lang.reflect.InvocationTargetException;

public interface ITerrainFactory {
    ITerrain createTerrain(String terrainType, int x, int y) throws
            InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;
}
