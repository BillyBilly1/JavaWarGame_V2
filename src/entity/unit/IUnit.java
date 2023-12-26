package entity.unit;

import javax.swing.*;

public interface IUnit {

    int getX();

    int getY();

    void setLocation(int x, int y);

    ImageIcon getDisplayedIcon();

    boolean isLeft();

    int getStrength();

}
