package interface_adapter.set_up_players;

import use_case.set_up_players.SetUpPlayersOutputBoundary;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SetUpPlayersState {

    private String player1Name = null;

    private String player2Name = null;

    private String initialMoney = null;

    private String initialFoodAmount = null;

    private String moneyErrorMessage = "";

    private String foodAmountErrorMessage = "";

    // This attribute is false when money or food amount is invalid
    // for example, one of them is zero or is not integers
    private boolean validMoneyInput = false;

    private boolean validFoodAmountInput = false;

    public SetUpPlayersState(SetUpPlayersState copy) {
        player1Name = copy.player1Name;
        player2Name = copy.player2Name;
        initialMoney = copy.player2Name;
        initialFoodAmount = copy.player2Name;
        moneyErrorMessage = copy.moneyErrorMessage;
        foodAmountErrorMessage = copy.foodAmountErrorMessage;
        validMoneyInput = copy.validMoneyInput;
        validFoodAmountInput = copy.validFoodAmountInput;
    }

    public SetUpPlayersState() {}

    public String getPlayer1Name() {
        return player1Name;
    }

    public void setPlayer1Name(String player1Name) {
        this.player1Name = player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public void setPlayer2Name(String player2Name) {
        this.player2Name = player2Name;
    }

    public String getInitialMoney() {
        return initialMoney;
    }

    public void setInitialMoney(String initialMoney) {
        this.initialMoney = initialMoney;
    }

    public String getInitialFoodAmount() {
        return initialFoodAmount;
    }

    public void setInitialFoodAmount(String initialFoodAmount) {
        this.initialFoodAmount = initialFoodAmount;
    }

    public String getMoneyErrorMessage() {
        return moneyErrorMessage;
    }

    public void setMoneyErrorMessage(String moneyErrorMessage) {
        this.moneyErrorMessage = moneyErrorMessage;
    }

    public String getFoodAmountErrorMessage() {
        return foodAmountErrorMessage;
    }

    public void setFoodAmountErrorMessage(String foodAmountErrorMessage) {
        this.foodAmountErrorMessage = foodAmountErrorMessage;
    }

    public boolean isValidMoneyInput() {
        return validMoneyInput;
    }

    public void setValidMoneyInput(boolean validMoneyInput) {
        this.validMoneyInput = validMoneyInput;
    }

    public boolean isValidFoodAmountInput() {
        return validFoodAmountInput;
    }

    public void setValidFoodAmountInput(boolean validFoodAmountInput) {
        this.validFoodAmountInput = validFoodAmountInput;
    }
}
