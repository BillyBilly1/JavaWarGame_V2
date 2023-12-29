package use_case.set_up_players;

import domain.entity.Player.IPlayerFactory;
import domain.entity.Player.PlayerFactory;

public class SetUpPlayersInteractor implements SetUpPlayersInputBoundary{

    final SetUpPlayersDataAccessInterface setUpPlayersDataAccessObject;

    final SetUpPlayersOutputBoundary setUpPlayersPresenter;

    final IPlayerFactory playerFactory;

    public SetUpPlayersInteractor(SetUpPlayersDataAccessInterface setUpPlayersDataAccessObject,
                                  SetUpPlayersOutputBoundary setUpPlayersPresenter, IPlayerFactory playerFactory) {
        this.setUpPlayersDataAccessObject = setUpPlayersDataAccessObject;
        this.setUpPlayersPresenter = setUpPlayersPresenter;
        this.playerFactory = playerFactory;
    }


    @Override
    public void execute(SetUpPlayersInputData setUpPlayersInputData) {
        String name1 = setUpPlayersInputData.getName1();
        String name2 = setUpPlayersInputData.getName2();
        int money = setUpPlayersInputData.getMoney();
        int foodAmount = setUpPlayersInputData.getFoodAmount();
        setUpPlayersDataAccessObject.setPlayer(playerFactory.createPlayer
                (name1, true, money, foodAmount));
        // The left parameter of the first player must be true, and that of the second is false.
        setUpPlayersDataAccessObject.setPlayer(playerFactory.createPlayer
                (name2, false, money, foodAmount));
    }
}
