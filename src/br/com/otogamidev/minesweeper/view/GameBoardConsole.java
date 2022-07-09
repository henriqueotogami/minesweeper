package br.com.otogamidev.minesweeper.view;

import br.com.otogamidev.minesweeper.exception.ExitException;
import br.com.otogamidev.minesweeper.exception.ExplosionException;
import br.com.otogamidev.minesweeper.model.GameBoard;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class GameBoardConsole {

    private GameBoard gameBoard;
    private Scanner scannerInput = new Scanner(System.in);

    public GameBoardConsole(final GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        executeGame();
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public Scanner getScannerInput() {
        return scannerInput;
    }

    private void executeGame() {
        final String NO_CONTINUE_GAME = "n";
        final String YES_CONTINUE_GAME = "Y";
        try{
            boolean continueGame = true;
            while(continueGame) {
                gameBoardStructure();
                System.out.println("Do you want to play the next game?");
                System.out.println("Answer: Y / n");
                final String answerContinueGame = getScannerInput().nextLine();
                if(NO_CONTINUE_GAME.equalsIgnoreCase(answerContinueGame)){
                    continueGame = false;
                } else if (YES_CONTINUE_GAME.equals(answerContinueGame)){
                    getGameBoard().restartBoardGame();
                }
            }

        } catch (final ExitException e) {
            System.out.println("Goodbye!");
        } finally {
            scannerInput.close();
        }
    }

    private void gameBoardStructure() {
        final String OPEN = "1";
        final String CLOSE = "2";
        final String COMMA = ",";
        final String CARRIAGE_RETURN = "\r\n";
        try{
            while(getGameBoard().safeBoardFieldObjective() == false){
                System.out.println(getGameBoard());
                String messageToUser = "Type integer numbers (x,y): ";
                String capturedValue = captureValue(messageToUser);
                Iterator<Integer> gameBoardAxes = Arrays.stream(capturedValue.split(COMMA))
                        .map(fieldAxis -> Integer.parseInt(fieldAxis.trim())).iterator();
                final int capturedXaxis = gameBoardAxes.next();
                final int capturedYaxis = gameBoardAxes.next();
                System.out.println("X axis: " + capturedXaxis);
                System.out.println("Y axis: " + capturedYaxis);
                System.out.println("Type an integer value below.");
                messageToUser = "Open: type 1." + CARRIAGE_RETURN +
                                "Close: type 2" + CARRIAGE_RETURN +
                                "Type your choice: ";
                capturedValue = captureValue(messageToUser);
                if(OPEN.equals(capturedValue)){
                    getGameBoard().openBoardField(capturedXaxis, capturedYaxis);
                } else if(CLOSE.equals(capturedValue)){
                    getGameBoard().changeMarkedBoardField(capturedXaxis, capturedYaxis);
                }
            }
            System.out.println("Congrats!");
            System.out.println(getGameBoard());
            System.out.println("You won!");
        } catch(ExplosionException explosion){
            System.out.println("Explosion!");
            System.out.println(getGameBoard());
            System.out.println("You lose!");
        }
    }

    private String captureValue(final String messageToUser){
        System.out.print(messageToUser);
        final String QUIT_GAME = "QUIT";
        final String requestCaptured = scannerInput.nextLine();
        if(QUIT_GAME.equalsIgnoreCase(requestCaptured)){
            throw new ExitException();
        }
        return requestCaptured;
    }

}
