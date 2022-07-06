package br.com.otogamidev.minesweeper.view;

import br.com.otogamidev.minesweeper.exception.ExitException;
import br.com.otogamidev.minesweeper.model.GameBoard;

public class GameBoardConsole {

    private GameBoard gameBoard;

    public GameBoardConsole(final GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        executeGame();
    }

    private void executeGame() {
        try{

        } catch (final ExitException e) {
            System.out.println("Goodbye!");
        }
    }

}
