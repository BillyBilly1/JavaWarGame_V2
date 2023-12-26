package entity.unit;

import entity.Placeable;

import javax.swing.*;

public abstract class Unit implements IUnit, Placeable {

    private int x;

    private int y;

    private final String name = this.getClass().getSimpleName();

    private final String iconPath;

    private final String flippedIconPath;

    private final ImageIcon displayedIcon;

    private final boolean left;

    public Unit(int x, int y, String iconPath, String flippedIconPath, boolean left) {
        this.x = x;
        this.y = y;
        this.iconPath = iconPath;
        this.flippedIconPath = flippedIconPath;
        this.left = left;
        //If the unit belongs to the LEFT player,
        // then the displayed icon faces to the right.(icon)
        if (this.left) {
            displayedIcon = new ImageIcon(iconPath);
        }
        //If the unit belongs to the RIGHT player,
        // then the displayed icon faces to the left.(flippedIcon)
        else {
            displayedIcon = new ImageIcon(flippedIconPath);
        }
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
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public ImageIcon getDisplayedIcon() {
        return displayedIcon;
    }

    @Override
    public boolean isLeft() {
        return left;
    }

}
