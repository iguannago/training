package com.get_in_the_cloud.backend;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by davicres on 12/01/2017.
 */
public class GameTest {

    private final Player player1 = Player.of("Player1", PlayerColours.RED);
    private final Player player2 = Player.of("Player2", PlayerColours.YELLOW);
    private final Game game = Game.of(player1, player2, GameBoard.of(new PlayerColours[6][7]), "no outcome yet");

    @Test
    public void gameIsStarted() {
        assertNotNull(game);
        assertNotNull(player1);
        assertNotNull(player2);
        assertNotNull(game.getGameBoard());
        assertEquals("no outcome yet", game.getOutcome());
    }

    @Test
    public void playerDropsDiscOnANonFullColumnToWin() {
        int column = 1;
        int row = 6;
        dropDiscRecursive(row, column, game);
    }

    private Game dropDiscRecursive(int row, int column, Game game) {
        if (game.getOutcome().equals(player1.getName() + " wins")) {
            return game;
        }
        Game nextGame = game.playerDropsDiscOnColumn(player1, column);
        assertEquals(player1.getColour(), nextGame.getGameBoard().getCellColourForGivenRowAndColumn(row, column));
        return dropDiscRecursive(--row, column, nextGame);
    }

    @Test
    public void playerDropsDiscForwardTheRight4TimesHorizontallyToWinGame() throws Exception {
        Game givenGame = givenStartedGameWith3RedDiscsHorizontallyInLineForwardRight();
        Game nextGame = givenGame.playerDropsDiscOnColumn(player1, 4);
        assertEquals("Player1 wins", nextGame.getOutcome());
    }

    private Game givenStartedGameWith3RedDiscsHorizontallyInLineForwardRight() {
        PlayerColours[][] board = new PlayerColours[6][7];
        board[5][0] = PlayerColours.RED;
        board[5][1] = PlayerColours.RED;
        board[5][2] = PlayerColours.RED;
        GameBoard gameBoard = GameBoard.of(board);
        return Game.of(player1, player2, gameBoard, "no outcome yet");
    }

    @Test
    public void playerDropsDiscForwardTheLeft4TimesHorizontallyToWinGame() throws Exception {
        Game givenGame = givenStartedGameWith3RedDiscsHorizontallyInLineForwardLeft();
        Game nextGame = givenGame.playerDropsDiscOnColumn(player1, 4);
        assertEquals("Player1 wins", nextGame.getOutcome());
    }

    private Game givenStartedGameWith3RedDiscsHorizontallyInLineForwardLeft() {
        PlayerColours[][] board = new PlayerColours[6][7];
        board[5][6] = PlayerColours.RED;
        board[5][5] = PlayerColours.RED;
        board[5][4] = PlayerColours.RED;
        GameBoard gameBoard = GameBoard.of(board);
        return Game.of(player1, player2, gameBoard, "no outcome yet");

    }
}
