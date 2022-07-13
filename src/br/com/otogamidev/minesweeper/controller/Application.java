package br.com.otogamidev.minesweeper.controller;

import br.com.otogamidev.minesweeper.model.GameBoard;
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
