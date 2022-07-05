package br.com.otogamidev.minesweeper.model;

public class Application {

    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard(6,6,6);
        gameBoard.openBoardField(3,3);
        gameBoard.changeMarkedBoardField(4,4);
        gameBoard.changeMarkedBoardField(4,5);
        System.out.println(gameBoard);
    }
}
