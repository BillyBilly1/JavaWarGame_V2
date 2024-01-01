import database.board.BoardRepositoryInterface;
import database.board.InMemoryBoardRepository;
import database.game.GameRepositoryInterface;
import database.game.InMemoryGameRepository;
import database.player.InMemoryPlayerRepository;
import database.player.PlayerRepositoryInterface;
import database.unit.InMemoryUnitRepository;
import database.unit.UnitRepositoryInterface;
import interface_adapter.MenuViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.initialize_game.InitializeGameController;
import interface_adapter.initialize_game.InitializeGameViewModel;
import interface_adapter.load_game.LoadGameController;
import interface_adapter.set_up_players.SetUpPlayersViewModel;
import view.InitializeGameView;
import view.MenuView;
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
        MenuViewModel menuViewModel = new MenuViewModel();
        SetUpPlayersViewModel setUpPlayersViewModel = new SetUpPlayersViewModel();
        InitializeGameViewModel initializeGameViewModel = new InitializeGameViewModel();

        // ViewManagerModel
        ViewManagerModel viewManagerModel = new ViewManagerModel();

        // Create Views

        MenuView menuView = new MenuView(viewManagerModel, menuViewModel, new LoadGameController());
        SetUpPlayersView setUpPlayersView = SetUpPlayersViewFactory.create(viewManagerModel,
                setUpPlayersViewModel, playerRepository);


        InitializeGameView initializeGameView =
                new InitializeGameView(initializeGameViewModel, new InitializeGameController());


        JFrame application = new JFrame("JWarGame");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // Register all the views
        JPanel views = new JPanel(cardLayout);
        views.add(menuView, menuViewModel.getViewName());
        views.add(setUpPlayersView, setUpPlayersViewModel.getViewName());
        views.add(initializeGameView, initializeGameViewModel.getViewName());


        application.add(views);
        new ViewManager(views, cardLayout, viewManagerModel);
        viewManagerModel.setActiveView(menuViewModel.getViewName());

        application.pack();

        application.setLocationRelativeTo(null);

        application.setVisible(true);

    }
}
