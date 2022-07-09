package br.com.otogamidev.minesweeper.model;

import br.com.otogamidev.minesweeper.view.GameBoardConsole;

/**
 * Class responsible for initializing the board game.
 */
public class Application {

    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard(6,6,6);
        new GameBoardConsole(gameBoard);
    }
}
