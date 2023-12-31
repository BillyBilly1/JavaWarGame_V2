import data_access.SetUpPlayerDataAccessObject;
import database.board.BoardRepositoryInterface;
import database.board.InMemoryBoardRepository;
import database.game.GameRepositoryInterface;
import database.game.InMemoryGameRepository;
import database.player.InMemoryPlayerRepository;
import database.player.PlayerRepositoryInterface;
import database.unit.InMemoryUnitRepository;
import database.unit.UnitRepositoryInterface;
import domain.entity.Player.IPlayerFactory;
import domain.entity.Player.PlayerFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.initialize_game.InitializeGameViewModel;
import interface_adapter.set_up_players.SetUpPlayerPresenter;
import interface_adapter.set_up_players.SetUpPlayersController;
import interface_adapter.set_up_players.SetUpPlayersState;
import interface_adapter.set_up_players.SetUpPlayersViewModel;
import use_case.set_up_players.SetUpPlayersDataAccessInterface;
import use_case.set_up_players.SetUpPlayersInputBoundary;
import use_case.set_up_players.SetUpPlayersInteractor;
import use_case.set_up_players.SetUpPlayersOutputBoundary;
import view.SetUpPlayersView;
import view.ViewManager;
import view_factory.SetUpPlayersViewFactory;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Create InMemory Repositories
        UnitRepositoryInterface unitRepository = new InMemoryUnitRepository();
        PlayerRepositoryInterface playerRepository = new InMemoryPlayerRepository();
        BoardRepositoryInterface boardRepository = new InMemoryBoardRepository();
        GameRepositoryInterface gameRepository = new InMemoryGameRepository();


        // Create ViewModels
        SetUpPlayersViewModel setUpPlayersViewModel = new SetUpPlayersViewModel();
        InitializeGameViewModel initializeGameViewModel = new InitializeGameViewModel();

        // Create Views
        SetUpPlayersView setUpPlayersView = SetUpPlayersViewFactory.create(
                setUpPlayersViewModel, playerRepository);




        JFrame application = new JFrame("JWarGame");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // Register all the views
        JPanel views = new JPanel(cardLayout);
        views.add(setUpPlayersView);


        application.add(views);
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);
        viewManagerModel.setActiveView("set up players");

        application.pack();

        application.setLocationRelativeTo(null);

        application.setVisible(true);

    }
}
