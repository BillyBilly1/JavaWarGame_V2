package domain.entity.terrain;

import all_class.AllClassList;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class TerrainFactory implements ITerrainFactory{

    private static final Map<String, Class<? extends ITerrain>> registeredTerrains = new HashMap<>();

    static {
        for (Class<? extends ITerrain> clazz : AllClassList.getTerrainClassList()) {
            registerTerrain(clazz);
    }

}

    private static void registerTerrain(Class<? extends ITerrain> terrainClass) {
        registeredTerrains.put(terrainClass.getSimpleName(), terrainClass);
    }

    @Override
    public ITerrain createTerrain(String terrainType, int x, int y) throws
            InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Class<? extends ITerrain> terrainClass = registeredTerrains.get(terrainType);
        if (terrainClass == null) {
            throw new IllegalArgumentException("Terrain type not registered.");
        }
        Constructor<? extends ITerrain> constructor = terrainClass.getConstructor(
                int.class, int.class);
        return constructor.newInstance(x, y);
    }
}
