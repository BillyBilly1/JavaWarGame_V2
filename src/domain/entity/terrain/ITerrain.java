package domain.entity.terrain;

import domain.entity.Placeable;

import javax.swing.*;

public interface ITerrain extends Placeable {

    int getX();

    int getY();

    int getHeight();

    String getIconPath();

    ImageIcon getDisplayedIcon();
}
