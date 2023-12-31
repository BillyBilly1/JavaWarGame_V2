package interface_adapter.set_up_players;

import interface_adapter.ViewManagerModel;
import interface_adapter.initialize_game.InitializeGameViewModel;
import use_case.set_up_players.SetUpPlayersOutputBoundary;
import use_case.set_up_players.SetUpPlayersOutputData;

import javax.swing.*;

public class SetUpPlayerPresenter implements SetUpPlayersOutputBoundary {

    private final SetUpPlayersViewModel setUpPlayersViewModel;

    private final InitializeGameViewModel initializeGameViewModel;

    private final ViewManagerModel viewManagerModel;

    public SetUpPlayerPresenter(SetUpPlayersViewModel setUpPlayersViewModel,
                                InitializeGameViewModel initializeGameViewModel,
                                ViewManagerModel viewManagerModel) {
        this.setUpPlayersViewModel = setUpPlayersViewModel;
        this.initializeGameViewModel = initializeGameViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(SetUpPlayersOutputData outputData) {
        String message = outputData.getMessage();
        JOptionPane.showMessageDialog(null, message);
        viewManagerModel.setActiveView("initialize game");
        viewManagerModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(SetUpPlayersOutputData outputData) {

        SetUpPlayersState currentState = new SetUpPlayersState(setUpPlayersViewModel.getSetUpPlayersState());
        currentState.setPlayer1Name("");
        currentState.setPlayer2Name("");
        setUpPlayersViewModel.setSetUpPlayersState(currentState);
        String errorMessage = outputData.getMessage();
        JOptionPane.showMessageDialog(null,
                errorMessage,
                "Input Error", JOptionPane.ERROR_MESSAGE);
        setUpPlayersViewModel.firePropertyChanged("sameName");

    }
}
