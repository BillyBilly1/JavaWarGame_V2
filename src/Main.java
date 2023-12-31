import data_access.SetUpPlayerDataAccessObject;
import database.player.InMemoryPlayerRepository;
import database.player.PlayerRepositoryInterface;
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
import view_factory.SetUpPlayersViewFactory;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 创建 JFrame 实例
            JFrame frame = new JFrame("Set Up Players");

            PlayerRepositoryInterface playerRepository = new InMemoryPlayerRepository();

            // 设置关闭操作，确保应用程序可以正确关闭
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            SetUpPlayersViewModel setUpPlayersViewModel = new SetUpPlayersViewModel();
            SetUpPlayersView setUpPlayersView = SetUpPlayersViewFactory.create(setUpPlayersViewModel);

            // 将 SetUpPlayersView 添加到 JFrame
            frame.add(setUpPlayersView);

            // 调整 JFrame 大小以适应组件
            frame.pack();

            frame.setLocationRelativeTo(null);


            // 设置 JFrame 为可见
            frame.setVisible(true);
        });
    }
}
