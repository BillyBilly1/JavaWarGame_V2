package interface_adapter.set_up_players;

import use_case.set_up_players.SetUpPlayersInputBoundary;
import use_case.set_up_players.SetUpPlayersInputData;

public class SetUpPlayersController {

    final SetUpPlayersInputBoundary setUpPlayersInteractor;

    public SetUpPlayersController(SetUpPlayersInputBoundary setUpPlayersInteractor) {
        this.setUpPlayersInteractor = setUpPlayersInteractor;
    }

    public void execute(String player1Name, String player2Name, String initialMoney, String initialFoodAmount) {
        SetUpPlayersInputData setUpPlayersInputData =
                new SetUpPlayersInputData(player1Name, player2Name, initialMoney, initialFoodAmount);
        setUpPlayersInteractor.execute(setUpPlayersInputData);
    }
}
