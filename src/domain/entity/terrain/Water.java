package domain.entity.terrain;

public class Water extends Terrain{

    private static final int height = 1;

    private static final String iconPath = "src/icon/terrain/Water.png";


    protected Water(int x, int y) {
        super(x, y, height, iconPath);
    }
}
