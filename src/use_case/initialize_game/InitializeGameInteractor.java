package use_case.initialize_game;

import database.game.InMemoryGameRepository;
import domain.entity.Player.IPlayer;
import domain.entity.board.IBoard;
import domain.entity.board.IBoardFactory;
import domain.entity.game.IGame;
import domain.entity.game.IGameFactory;

public class InitializeGameInteractor implements InitializeGameInputBoundary {

    final InitializeGameDataAccessInterface initializeGameDataAccessObject;

    final InitializeGameOutputBoundary initializeGamePresenter;

    final IBoardFactory BoardFactory;

    final IGameFactory GameFactory;


    public InitializeGameInteractor(InitializeGameDataAccessInterface initializeGameDataAccessObject,
                                    InitializeGameOutputBoundary initializeGamePresenter,
                                    IBoardFactory boardFactory, IGameFactory gameFactory) {
        this.initializeGameDataAccessObject = initializeGameDataAccessObject;
        this.initializeGamePresenter = initializeGamePresenter;
        BoardFactory = boardFactory;
        GameFactory = gameFactory;
    }

    @Override
    public void execute(InitializeGameInputData initializeGameInputData) {
        // create and save a board
        int width = initializeGameInputData.getWidth();
        int height = initializeGameInputData.getHeight();
        IBoard board = BoardFactory.createBoard(width, height);
        initializeGameDataAccessObject.setBoard(board);

        // load players from DAO, and create and save a game
        IPlayer player1 = initializeGameDataAccessObject.loadPlayer(true);
        IPlayer player2 = initializeGameDataAccessObject.loadPlayer(false);
        IGame game = GameFactory.createGame(board, player1, player2);
        initializeGameDataAccessObject.setGame(game);

        initializeGamePresenter.prepareSuccessView();
    }
}
