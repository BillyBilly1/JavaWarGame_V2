package data_access;

import database.board.BoardRepositoryInterface;
import database.game.GameRepositoryInterface;
import database.player.PlayerRepositoryInterface;
import domain.entity.Player.IPlayer;
import domain.entity.board.IBoard;
import domain.entity.game.Game;
import domain.entity.game.IGame;
import use_case.initialize_game.InitializeGameDataAccessInterface;

public class InitializeGameDataAccessObject implements InitializeGameDataAccessInterface {

    private final PlayerRepositoryInterface playerRepository;

    private final BoardRepositoryInterface boardRepository;

    private final GameRepositoryInterface gameRepository;


    public InitializeGameDataAccessObject(PlayerRepositoryInterface playerRepository,
                                          BoardRepositoryInterface boardRepository,
                                          GameRepositoryInterface gameRepository) {
        this.playerRepository = playerRepository;
        this.boardRepository = boardRepository;
        this.gameRepository = gameRepository;
    }


    @Override
    public IPlayer loadPlayer(boolean left) {
        return playerRepository.loadPlayer(left);
    }

    @Override
    public void setBoard(IBoard board) {
        boardRepository.setBoard(board);
    }

    @Override
    public void setGame(IGame game) {
        gameRepository.setGame(game);
    }
}
