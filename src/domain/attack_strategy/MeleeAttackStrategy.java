package domain.attack_strategy;

import domain.Victim;
import domain.entity.CanAttack;
import domain.entity.OperationNumConstant;
import domain.entity.Player.IPlayer;
import domain.entity.board.IBoard;

import static java.lang.Float.min;

public class MeleeAttackStrategy extends AttackStrategy {
    @Override
    public AttackResult attack(AttackData attackData) {
        CanAttack attacker = attackData.getAttacker();
        Victim victim = attackData.getVictim();
        IPlayer attackPlayer = attackData.getAttackerPlayer();
        IPlayer victimPlayer = attackData.getVictimPlayer();
        IBoard board = attackData.getBoard();

        float nominalDamage = attacker.getAttack() + attacker.getAtkBuff() +
                attacker.getStaminaBasedAttackDebuff()-
                victim.getDefense() - victim.getDefBuff();

        float actualDamage = min(nominalDamage, victim.getHp());
        float afterAttackHp = victim.getHp() - actualDamage;
        victim.setHp(afterAttackHp);

        int afterAttackOperationNum = attacker.getOperationNum() - attacker.getAttackOperationNumCost();
        attacker.setOperationNum(afterAttackOperationNum);

        boolean successAttack = true;
        boolean dead = victim.getHp() <= 0;

        String message = null;

        if (dead) {
            message = actualDamage + "has been committed, and the ";
        }


        AttackResult attackResult = new AttackResult(successAttack, dead, message);

        return attackResult;
    }
}
