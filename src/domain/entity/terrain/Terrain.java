package domain.entity.terrain;

import domain.entity.Placeable;

import javax.swing.*;

public abstract class Terrain implements ITerrain, Placeable {

    protected final int x;

    protected final int y;

    protected final int height;

    protected final String iconPath;

    protected final ImageIcon displayedIcon;


    protected Terrain(int x, int y, int height, String iconPath) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.iconPath = iconPath;
        this.displayedIcon = new ImageIcon(iconPath);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getHeight() {return this.height;}

    @Override
    public String getIconPath() {
        return iconPath;
    }

    @Override
    public ImageIcon getDisplayedIcon() {
        return displayedIcon;
    }
}
