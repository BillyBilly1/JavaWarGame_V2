package domain.entity;

// Terrain class and Unit class are placeable. They both share the method of getX and getY

import javax.swing.*;

public interface Placeable {
    int getX();

    int getY();

    int getHeight();

    ImageIcon getDisplayedIcon();
}
