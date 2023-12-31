package domain.entity.unit;

import domain.entity.Placeable;

import javax.swing.*;

public interface IUnit extends Placeable {
    int getX();

    void setX(int x);

    int getY();

    void setY(int y);

    void setLocation(int x, int y);

    String getName();

    String getIconPath();

    String getFlippedIconPath();

    ImageIcon getDisplayedIcon();

    boolean isLeft();

    String getId();

    float getMaxHp();

    float getHp();

    void setHp(float hp);

    float getDefense();

    float getDefBuff();

    void setDefBuff(float defBuff);

    int getPrice();

    int getHeight();

    int getStrength();

    float getKillRewardMultiplier();
}
