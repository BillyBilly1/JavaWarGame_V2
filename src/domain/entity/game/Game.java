package domain.entity.game;

import domain.entity.Player.IPlayer;
import domain.entity.board.IBoard;

import java.math.BigDecimal;

public class Game implements IGame{

    private final IBoard board;

    private final IPlayer player1;

    private final IPlayer player2;

    private int turn = 0;

    private boolean leftTurn = true;

    public Game(IBoard board, IPlayer player1, IPlayer player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }


    public void setBothPriceCoefficient() {
        int player1OverallStrength = player1.getOverallStrengthRating();
        int player2OverallStrength = player2.getOverallStrengthRating();
        if (player1OverallStrength > 1.5 * player2OverallStrength) {
            float ratio = (float) player1OverallStrength / player2OverallStrength;
            ratio *= 100;
            ratio = Math.round(ratio);
            ratio /= 100;
            player1.setPriceCoefficient((float) Math.min(2, 1 + ratio - 1.5));
            player2.setPriceCoefficient(0.9f);
        }
        else if (player2OverallStrength > 1.5 * player1OverallStrength) {
            float ratio = (float) player2OverallStrength / player1OverallStrength;
            ratio *= 100;
            ratio = Math.round(ratio);
            ratio /= 100;
            player2.setPriceCoefficient((float) Math.min(2, 1 + ratio - 1.5));
            player1.setPriceCoefficient(0.9f);}

        else {
            player1.setPriceCoefficient(1);
            player2.setPriceCoefficient(1);
        }
    }
}
