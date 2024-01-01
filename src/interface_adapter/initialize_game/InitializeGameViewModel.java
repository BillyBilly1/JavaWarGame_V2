package interface_adapter.initialize_game;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class InitializeGameViewModel extends ViewModel {

    public static final String viewName = "initialize game";

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    private InitializeGameState initializeGameState = new InitializeGameState();

    public InitializeGameViewModel() {
        super("initialize game");
    }


    public InitializeGameState getInitializeGameState() {
        return initializeGameState;
    }

    public void setInitializeGameState(InitializeGameState initializeGameState) {
        this.initializeGameState = initializeGameState;
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void firePropertyChanged(String propertyName) {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

    public void validateAndSetWidth(String input) {
    }

    public void validateAndSetHeight(String input) {
    }
}
