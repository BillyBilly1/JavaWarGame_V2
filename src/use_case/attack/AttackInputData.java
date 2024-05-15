package use_case.attack;

import domain.entity.CanAttack;

public class AttackInputData {

    private final CanAttack attacker;

    private final int victimX;

    private final int victimY;


    public AttackInputData(CanAttack attacker, int victimX, int victimY) {

        this.attacker = attacker;
        this.victimX = victimX;
        this.victimY = victimY;
    }

    public CanAttack getAttacker() {
        return attacker;
    }

    public int getVictimX() {
        return victimX;
    }

    public int getVictimY() {
        return victimY;
    }
}

