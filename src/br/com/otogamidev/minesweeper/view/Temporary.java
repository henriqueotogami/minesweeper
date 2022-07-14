package br.com.otogamidev.minesweeper.view;

import br.com.otogamidev.minesweeper.model.GameBoard;

public class Temporary {
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard(3,3,9);

        gameBoard.registerGameBoardObserver(gameBoardObserver -> {
            if(gameBoardObserver.isGameMatchWonByUser()) {
                System.out.println("You won.");
            } else {
                System.out.println("You lose.");
            }
        });

        gameBoard.changeMarkedBoardField(0,0);
        gameBoard.changeMarkedBoardField(0,1);
        gameBoard.changeMarkedBoardField(0,2);
        gameBoard.changeMarkedBoardField(1,0);
        gameBoard.changeMarkedBoardField(1,1);
        gameBoard.changeMarkedBoardField(1,2);
        gameBoard.changeMarkedBoardField(2,0);
        gameBoard.changeMarkedBoardField(2,1);
        gameBoard.changeMarkedBoardField(2,2);

    }
}
