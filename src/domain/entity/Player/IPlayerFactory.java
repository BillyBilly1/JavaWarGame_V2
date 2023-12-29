package domain.entity.Player;

public interface IPlayerFactory {

    IPlayer createPlayer(String name, boolean left, int money, int foodAmount);
}
