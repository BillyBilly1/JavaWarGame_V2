package use_case.set_up_players;

import domain.entity.Player.IPlayerFactory;

public class SetUpPlayersInteractor implements SetUpPlayersInputBoundary {

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

        if (name1.equals(name2)) {
            SetUpPlayersOutputData setUpPlayersOutputData =
                    new SetUpPlayersOutputData("Player1's name and Player2's name cannot be the same, " +
                            "please try again.");
            setUpPlayersPresenter.prepareSameNameFailView(setUpPlayersOutputData);

        }
        // Note that money and foodAmount must be able to be converted to integers
        // since they are already checked to be digits in ViewModel.
        else {
            try {
                int money = Integer.parseInt(setUpPlayersInputData.getMoney());
                int foodAmount = Integer.parseInt(setUpPlayersInputData.getFoodAmount());
                setUpPlayersDataAccessObject.setPlayer(playerFactory.createPlayer
                        (name1, true, money, foodAmount));
                // The left parameter of the first player must be true, and that of the second is false.
                setUpPlayersDataAccessObject.setPlayer(playerFactory.createPlayer
                        (name2, false, money, foodAmount));
                SetUpPlayersOutputData setUpPlayersOutputData =
                        new SetUpPlayersOutputData("Player1 and Player2 are successfully created.");
                setUpPlayersPresenter.prepareSuccessView(setUpPlayersOutputData);
            } catch (NumberFormatException e) {
                SetUpPlayersOutputData setUpPlayersOutputData =
                        new SetUpPlayersOutputData("Invalid input for money or food amount. " +
                                "Please enter valid numbers.");
                setUpPlayersPresenter.prepareInvalidInputFailView(setUpPlayersOutputData);
            }

        }
    }
}
