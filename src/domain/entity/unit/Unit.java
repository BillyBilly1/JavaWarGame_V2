package domain.entity.unit;

import domain.entity.Placeable;
import domain.service.id.SingletonIDGenerator;
import domain.service.id.SingletonIntegerIDGenerator;

import javax.swing.*;

public abstract class Unit implements IUnit, Placeable {

    protected int x;

    protected int y;

    protected final String name = this.getClass().getSimpleName();

    protected final String id;

    protected final String iconPath;

    protected final String flippedIconPath;

    protected final ImageIcon displayedIcon;

    protected final boolean left;

    protected final float maxHp;

    protected float hp;

    protected final float defense;

    protected float defBuff = 0.0f;

    protected final int price;

    protected final int height;

    protected final float killRewardMultiplier;

    public Unit(int x, int y, boolean left, String id, float maxHp, float defense,
                int price, int height, float killRewardMultiplier, String iconPath, String flippedIconPath) {
        this.x = x;
        this.y = y;
        this.left = left;
        this.id = id;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.defense = defense;
        this.price = price;
        this.height = height;
        this.killRewardMultiplier = killRewardMultiplier;
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
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void setLocation(int x, int y) {
        setX(x);
        setY(y);
    }

    @Override
    public String getName() {
        return name;
    }



    @Override
    public String getIconPath() {
        return iconPath;
    }

    @Override
    public String getFlippedIconPath() {
        return flippedIconPath;
    }

    @Override
    public ImageIcon getDisplayedIcon() {
        return displayedIcon;
    }

    @Override
    public boolean isLeft() {
        return left;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public float getMaxHp() {
        return maxHp;
    }

    @Override
    public float getHp() {
        return hp;
    }

    @Override
    public void setHp(float hp) {
        if (hp < 0) {
            throw new IllegalArgumentException("hp must be greater than 0");
        }
        else if(hp > maxHp) {
            throw new IllegalArgumentException("hp could not exceed the maxHp");
        }
        else {this.hp = hp;}
    }

    @Override
    public float getDefense() {
        return defense;
    }

    @Override
    public float getDefBuff() {
        return defBuff;
    }

    @Override
    public void setDefBuff(float defBuff) {
        this.defBuff = defBuff;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getHeight() {return height;}

    @Override
    public float getKillRewardMultiplier() {
        return killRewardMultiplier;
    }
}
