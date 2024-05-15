package domain.attack_strategy;

import domain.Victim;
import domain.entity.CanAttack;
import domain.entity.Player.IPlayer;
import domain.entity.board.IBoard;
import domain.entity.unit.IUnit;
import domain.entity.unit.Unit;

public abstract class AttackStrategy {

    public abstract AttackResult attack(AttackData attackData);

    public void updatePlayer(IPlayer attackPlayer, IPlayer victimPlayer) {

    }


    public void updateBoard(IBoard board) {

    }

}
