package view_factory;

import data_access.SetUpPlayerDataAccessObject;
import database.player.InMemoryPlayerRepository;
import database.player.PlayerRepositoryInterface;
import domain.entity.Player.IPlayerFactory;
import domain.entity.Player.PlayerFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.initialize_game.InitializeGameViewModel;
import interface_adapter.set_up_players.SetUpPlayerPresenter;
import interface_adapter.set_up_players.SetUpPlayersController;
import interface_adapter.set_up_players.SetUpPlayersViewModel;
import use_case.set_up_players.SetUpPlayersDataAccessInterface;
import use_case.set_up_players.SetUpPlayersInputBoundary;
import use_case.set_up_players.SetUpPlayersInteractor;
import use_case.set_up_players.SetUpPlayersOutputBoundary;
import view.SetUpPlayersView;

public class SetUpPlayersViewFactory {

    public static SetUpPlayersView create(SetUpPlayersViewModel setUpPlayersViewModel) {

        SetUpPlayersController setUpPlayersController = createController(setUpPlayersViewModel);


        return new SetUpPlayersView(setUpPlayersViewModel, setUpPlayersController);
    }

    private static SetUpPlayersController createController(SetUpPlayersViewModel setUpPlayersViewModel) {
        PlayerRepositoryInterface playerRepository = new InMemoryPlayerRepository();
        InitializeGameViewModel initializeGameViewModel = new InitializeGameViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        SetUpPlayersDataAccessInterface setUpPlayersDataAccessObject
                = new SetUpPlayerDataAccessObject(playerRepository);
        IPlayerFactory playerFactory = new PlayerFactory();
        SetUpPlayersOutputBoundary setUpPlayersPresenter = new SetUpPlayerPresenter(
                setUpPlayersViewModel, initializeGameViewModel, viewManagerModel);
        SetUpPlayersInputBoundary setUpPlayersInteractor = new SetUpPlayersInteractor
                (setUpPlayersDataAccessObject, setUpPlayersPresenter, playerFactory);
        return new SetUpPlayersController(setUpPlayersInteractor);
    }



}
