package use_case.attack;

import domain.Victim;
import domain.attack_strategy.AttackData;
import domain.attack_strategy.AttackResult;
import domain.attack_strategy.AttackStrategy;
import domain.entity.CanAttack;
import domain.entity.Placeable;
import domain.entity.Player.IPlayer;
import domain.entity.board.IBoard;
import domain.entity.unit.IUnit;
import domain.entity.unit.Unit;

public class AttackInteractor implements AttackInputBoundary{

    final AttackDataAccessInterface attackDataAccessObject;

    final AttackOutputBoundary attackPresenter;


    public AttackInteractor(AttackDataAccessInterface attackDataAccessObject,
                            AttackOutputBoundary attackPresenter) {
        this.attackDataAccessObject = attackDataAccessObject;
        this.attackPresenter = attackPresenter;
    }

    @Override
    public void execute(AttackInputData attackInputData) {
        CanAttack attacker = attackInputData.getAttacker();
        int victimX = attackInputData.getVictimX();
        int victimY = attackInputData.getVictimY();
        IPlayer attackerPlayer = attackDataAccessObject.loadPlayer(attacker.isLeft());
        IPlayer victimPlayer = attackDataAccessObject.loadPlayer(!attacker.isLeft());
        IBoard board = attackDataAccessObject.loadBoard();

        String errorMessage = null;
        Placeable potentialVictim  = board.getPlaceableAt(victimX, victimY);
        if (!board.isOccupied(victimX, victimY)) {
            errorMessage = "There's nothing at (" + victimX + ", " + victimY + ")";
        } else if(!(potentialVictim  instanceof Victim)) {
            errorMessage = "Placeable at (" + victimX +", " + victimY + ") does not " +
                    "have an attackable property.";
        }
        else if(potentialVictim  instanceof Unit && ((Unit) potentialVictim ).isLeft() == attacker.isLeft()) {
            errorMessage = "You cannot attack your own Unit.";
        } else if(attacker.getOperationNum() <= 0) {
            errorMessage = "The attacker has no operation number left in this turn.";
        }

        Victim victim = (Victim) potentialVictim ;

        if (isInRange(attacker, victim)) {
            errorMessage = "The target is out of range, you cannot attack it";
        }
        if (errorMessage != null) {

        }

        AttackStrategy attackStrategy = attacker.getAttackStrategy();
        AttackData attackData = new AttackData(attacker, victim, attackerPlayer, victimPlayer, board);
        AttackResult attackResult = attackStrategy.attack(attackData);

    }



    private boolean isInRange(CanAttack attacker, Victim victim) {

        int[][] attackRange = attacker.getCurrentAttackRange();
        int[] victimCoordinate = new int[]{victim.getX(), victim.getY()};
        for (int[] attackCoordinate: attackRange) {
            if(java.util.Arrays.equals(attackCoordinate, victimCoordinate)) {
                return true;
            }
        }
        return false;
    }
}
