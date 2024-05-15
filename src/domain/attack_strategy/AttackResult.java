package domain.attack_strategy;

public class AttackResult {

    private final boolean successAttack;

    private final boolean dead;

    private final String message;


    public AttackResult(boolean successAttack, boolean dead, String message) {
        this.successAttack = successAttack;
        this.dead = dead;
        this.message = message;
    }

    public boolean isSuccessAttack() {
        return successAttack;
    }

    public boolean isDead() {
        return dead;
    }

    public String getMessage() {
        return message;
    }
}
