package domain.entity.unit;

import javax.swing.*;

public interface IUnit {
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
