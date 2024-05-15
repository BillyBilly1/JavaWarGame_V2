package domain;

public interface Victim {

    boolean isLeft();

    int getX();

    int getY();

    float getHp();

    void setHp(float hp);

    float getDefense();

    float getDefBuff();

    void setDefBuff(float defBuff);
}
