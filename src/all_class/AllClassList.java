package all_class;

import domain.entity.terrain.ITerrain;
import domain.entity.terrain.Water;
import domain.entity.unit.IUnit;
import domain.entity.unit.UnitFactory;
import domain.entity.unit.building.StoneWall;
import domain.entity.unit.building.WoodenFence;
import domain.entity.unit.combat_unit.melee.LanceKnight;
import domain.entity.unit.combat_unit.melee.SpearGuard;
import domain.entity.unit.combat_unit.ranged.Archer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllClassList {

    // All Unit classes and Terrain classes are stored here
    //

    private static final ArrayList<Class <? extends IUnit>> UnitClassList = new ArrayList<>();

    private static final ArrayList<Class <? extends ITerrain>> TerrainClassList = new ArrayList<>();

    // Unit
    static {
        // CombatUnit -- melee
        UnitClassList.add(SpearGuard.class);

        UnitClassList.add(LanceKnight.class);

        // CombatUnit -- ranged

        UnitClassList.add(Archer.class);

        // Building

        UnitClassList.add(WoodenFence.class);
        UnitClassList.add(StoneWall.class);
    }

    // Terrain
    static {
        TerrainClassList.add(Water.class);
    }


    public static List<Class <? extends IUnit>> getUnitClassList() {
        return Collections.unmodifiableList(UnitClassList);
    }

    public static List<Class <? extends ITerrain>> getTerrainClassList() {
        return Collections.unmodifiableList(TerrainClassList);
    }

}
