package com.get_in_the_cloud.backend;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;

/**
 * Created by davicres on 28/03/2017.
 */
@Value(staticConstructor = "of")
public class GameBoard {
    public static final int ROWS = 6;
    public static final int COLUMNS = 7;

    @Getter(AccessLevel.PRIVATE)
    private final PlayerColours[][] board;


    public PlayerColours getCellColourForGivenRowAndColumn(int row, int column) {
        return board[row - 1][column - 1];
    }

    public GameBoard setColourAt(int row, int column, PlayerColours colour) {
        PlayerColours[][] nextGameBoard = board.clone();
        nextGameBoard[row - 1][column - 1] = colour;
        return GameBoard.of(nextGameBoard);
    }
}
