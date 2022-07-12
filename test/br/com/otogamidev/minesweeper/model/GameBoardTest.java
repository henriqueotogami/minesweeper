package br.com.otogamidev.minesweeper.model;

import br.com.otogamidev.minesweeper.exception.ExplosionException;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest {

    @Test
    void checkSafeBoardFieldObjective() {
        final int gameBoardLines = 6;
        final int gameBoardColumns = 6;
        final int gameBoardUndermines = 6;
        GameBoard gameBoard = new GameBoard(gameBoardLines,gameBoardColumns,gameBoardUndermines);
        int tries = 0;
        boolean gameBoardIsSafe = false;
        final int gameBoardSize = (gameBoardLines * gameBoardColumns);
        while(gameBoardSize > tries++) {
            try {
                Random randomNumber = new Random();
                final int gameBoardRandomLine = randomNumber.nextInt(gameBoardLines);
                final int gameBoardRandomColumn = randomNumber.nextInt(gameBoardColumns);
                gameBoard.openBoardField(gameBoardRandomLine, gameBoardRandomColumn);
                gameBoardIsSafe = gameBoard.safeBoardFieldObjective();
            } catch(ExplosionException explosion) {
                assertFalse(gameBoard.safeBoardFieldObjective());
            }
        }
        if(gameBoardIsSafe){
            assertTrue(gameBoard.safeBoardFieldObjective());
        }
    }

    @Test
    void checkRestartBoardGame() {
        final int gameBoardLines = 6;
        final int gameBoardColumns = 6;
        final int gameBoardUndermines = 6;
        GameBoard gameBoard = new GameBoard(gameBoardLines,gameBoardColumns,gameBoardUndermines);
        Random randomNumber = new Random();
        final int gameBoardRandomLine = randomNumber.nextInt(gameBoardLines);
        final int gameBoardRandomColumn = randomNumber.nextInt(gameBoardColumns);
        gameBoard.changeMarkedBoardField(gameBoardRandomLine, gameBoardRandomColumn);
        final String gameBoardWithMarkedField = gameBoard.toString();
        gameBoard.restartBoardGame();
        final String gameBoardRestarted = gameBoard.toString();
        assertTrue((gameBoardWithMarkedField != gameBoardRestarted));
//        final String gameBoardDefaultModel =
//                "  0  1  2  3  4  5 " +
//                "0  ?  ?  ?  ?  ?  ? \n" +
//                "1  ?  ?  ?  ?  ?  ? \n" +
//                "2  ?  ?  ?  ?  ?  ? \n" +
//                "3  ?  ?  ?  ?  ?  ? \n" +
//                "4  ?  ?  ?  ?  ?  ? \n" +
//                "5  ?  ?  ?  ?  ?  ? ".length();
//
//        final String gameBoardDefaultModelUTF8 = "32\n" +
//                "48" +
//                "32" +
//                "32" +
//                "49" +
//                "32" +
//                "32" +
//                "50" +
//                "32" +
//                "32" +
//                "51" +
//                "32" +
//                "32" +
//                "52" +
//                "32" +
//                "32" +
//                "53" +
//                "32" +
//                "10" +
//                "48" +
//                "32" +
//                "32" +
//                "63" +
//                "32" +
//                "32" +
//                "63" +
//                "32" +
//                "32" +
//                "63" +
//                "32" +
//                "32" +
//                "63" +
//                "32" +
//                "32" +
//                "63" +
//                "32" +
//                "32" +
//                "63" +
//                "32" +
//                "10" +
//                "49" +
//                "32" +
//                "32" +
//                "63" +
//                "32" +
//                "32" +
//                "63" +
//                "32" +
//                "32" +
//                "63" +
//                "32" +
//                "32" +
//                "63" +
//                "32" +
//                "32" +
//                "63" +
//                "32"
//        System.out.println(gameBoardDefaultModel.length());
//        assertTrue((gameBoardRestarted == gameBoardDefaultModel));
    }

    @Test
    void checkToString() {
    }

    @Test
    void checkOpenBoardField() {
    }

    @Test
    void checkChangeMarkedBoardField() {
    }
}