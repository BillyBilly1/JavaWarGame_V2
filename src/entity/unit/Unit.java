package entity.unit;

import entity.Placeable;

import javax.swing.*;

public abstract class Unit implements IUnit, Placeable {

    protected int x;

    protected int y;


    protected final String name = this.getClass().getSimpleName();

    protected final String iconPath;

    protected final String flippedIconPath;

    protected final ImageIcon displayedIcon;

    protected final boolean left;

    protected final float maxHp;

    protected float hp;

    protected final float defense;

    protected float defBuff = 0.0f;

    protected final int price;

    public Unit(int x, int y, boolean left, float maxHp, float defense,
                int price, String iconPath, String flippedIconPath) {
        this.x = x;
        this.y = y;
        this.left = left;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.defense = defense;
        this.price = price;
        this.iconPath = iconPath;
        this.flippedIconPath = flippedIconPath;
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
