package domain.attack_strategy;

import domain.Victim;
import domain.entity.CanAttack;
import domain.entity.Player.IPlayer;
import domain.entity.board.IBoard;

public class AttackData {

    private final CanAttack attacker;

    private final Victim victim;

    private final IPlayer attackerPlayer;

    private final IPlayer victimPlayer;

    private final IBoard board;


    public AttackData(CanAttack attacker, Victim victim, IPlayer attackerPlayer, IPlayer victimPlayer, IBoard board) {
        this.attacker = attacker;
        this.victim = victim;
        this.attackerPlayer = attackerPlayer;
        this.victimPlayer = victimPlayer;
        this.board = board;
    }

    public CanAttack getAttacker() {
        return attacker;
    }

    public Victim getVictim() {
        return victim;
    }

    public IPlayer getAttackerPlayer() {
        return attackerPlayer;
    }

    public IPlayer getVictimPlayer() {
        return victimPlayer;
    }

    public IBoard getBoard() {
        return board;
    }
}
