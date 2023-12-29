package domain.entity.Player;

public class PlayerFactory implements IPlayerFactory {

    @Override
    public IPlayer createPlayer(String name, boolean left, int money, int foodAmount) {
        return new Player(name, left, money, foodAmount);
    }
}
