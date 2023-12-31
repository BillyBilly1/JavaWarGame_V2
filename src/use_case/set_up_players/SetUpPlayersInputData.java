package use_case.set_up_players;

public class SetUpPlayersInputData {

    private final String name1;

    private final String name2;

    private final String money;

    private final String foodAmount;


    public SetUpPlayersInputData(String name1, String name2, String money, String foodAmount) {
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

    public String getMoney() {
        return money;
    }

    public String getFoodAmount() {
        return foodAmount;
    }
}
