package data_access;

import database.board.BoardRepositoryInterface;
import domain.entity.board.IBoard;
import use_case.place_terrain.PlaceTerrainDataAccessInterface;

public class PlaceTerrainDataAccessObject implements PlaceTerrainDataAccessInterface {

    private final BoardRepositoryInterface boardRepository;

    public PlaceTerrainDataAccessObject(BoardRepositoryInterface boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public IBoard loadBoard() {
        return boardRepository.loadBoard();
    }

}
