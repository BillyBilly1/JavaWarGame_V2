package data_access;

import database.board.BoardRepositoryInterface;
import database.player.PlayerRepositoryInterface;
import domain.entity.Player.IPlayer;
import domain.entity.board.IBoard;
import use_case.attack.AttackDataAccessInterface;

public class AttackDataAccessObject implements AttackDataAccessInterface {

    private final PlayerRepositoryInterface playerRepository;

    private final BoardRepositoryInterface boardRepository;


    public AttackDataAccessObject(PlayerRepositoryInterface playerRepository, BoardRepositoryInterface boardRepository) {
        this.playerRepository = playerRepository;
        this.boardRepository = boardRepository;
    }

    @Override
    public IPlayer loadPlayer(boolean left) {
        return playerRepository.loadPlayer(left);
    }

    @Override
    public IBoard loadBoard() {
        return boardRepository.loadBoard();
    }

}



