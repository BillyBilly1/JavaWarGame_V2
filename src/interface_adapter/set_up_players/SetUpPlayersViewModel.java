package interface_adapter.set_up_players;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SetUpPlayersViewModel extends ViewModel {

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    private SetUpPlayersState setUpPlayersState = new SetUpPlayersState();

    public SetUpPlayersViewModel() {
        super("set up players");
    }

    public SetUpPlayersState getSetUpPlayersState() {
        return setUpPlayersState;
    }

    public void setSetUpPlayersState(SetUpPlayersState setUpPlayersState) {
        this.setUpPlayersState = setUpPlayersState;
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void firePropertyChanged(String propertyName) {
        if ("sameName".equals(propertyName)) {
            support.firePropertyChange("sameName", null, null);
        }

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void validateAndSetMoney(String input) {
        if (input.matches("\\d+")) {
            if (Integer.parseInt(input) != 0) {
                setUpPlayersState.setInitialMoney(input);
                setUpPlayersState.setMoneyErrorMessage("");
                setUpPlayersState.setValidMoneyInput(true);
            } else {
                setUpPlayersState.setMoneyErrorMessage("Initial money cannot be 0");
                setUpPlayersState.setValidMoneyInput(false);
            }
        }
        else {
            setUpPlayersState.setMoneyErrorMessage("Initial money must be an INTEGER!");
            setUpPlayersState.setValidMoneyInput(false);
        }
        support.firePropertyChange("moneyErrorMessage",
                null, setUpPlayersState.getFoodAmountErrorMessage());

    }

    public void validateAndSetFoodAmount(String input) {
        if (input.matches("\\d+")) {
            if (Integer.parseInt(input) != 0) {
                setUpPlayersState.setInitialFoodAmount(input);
                setUpPlayersState.setFoodAmountErrorMessage("");
                setUpPlayersState.setValidFoodAmountInput(true);
            } else {
                setUpPlayersState.setFoodAmountErrorMessage("Initial food amount cannot be 0");
                setUpPlayersState.setValidFoodAmountInput(false);
            }
        } else {
            setUpPlayersState.setFoodAmountErrorMessage("Initial food amount must be an INTEGER!");
            setUpPlayersState.setValidFoodAmountInput(false);
        }
        support.firePropertyChange("foodAmountErrorMessage",
                null, setUpPlayersState.getFoodAmountErrorMessage());

    }
}
