package use_case.set_up_players;

public class SetUpPlayersInputData {

    private final String name1;

    private final String name2;

    private final int money;

    private final int foodAmount;


    public SetUpPlayersInputData(String name1, String name2, int money, int foodAmount) {
        this.name1 = name1;
        this.name2 = name2;
        this.money = money;
        this.foodAmount = foodAmount;
    }

    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }

    public int getMoney() {
        return money;
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
