package entity.unit;

import entity.Placeable;

import javax.swing.*;

public class Unit implements IUnit, Placeable {

    private int x;

    private int y;

    private final String name = this.getClass().getSimpleName();

    private ImageIcon icon;

    private ImageIcon flippedIcon;

    private final ImageIcon displayedIcon;

    private final boolean left;

    public Unit(int x, int y, boolean Left) {
        this.x = x;
        this.y = y;
        this.left = Left;
        //If the unit belongs to the LEFT player,
        // then the displayed icon faces to the right.(icon)
        if (this.left) {
            displayedIcon = icon;
        }
        //If the unit belongs to the RIGHT player,
        // then the displayed icon faces to the left.(flippedIcon)
        else {
            displayedIcon = flippedIcon;
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
