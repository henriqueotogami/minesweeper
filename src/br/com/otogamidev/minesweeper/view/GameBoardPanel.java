package br.com.otogamidev.minesweeper.view;

import br.com.otogamidev.minesweeper.model.GameBoard;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class GameBoardPanel extends JPanel {

    public GameBoardPanel(final GameBoard gameBoard) {
        setLayout(new GridLayout(gameBoard.getBoardLines(), gameBoard.getBoardColumns()));
        gameBoard.getBoardFields().forEach(boardField -> add(new GameBoardButton(boardField)));
        gameBoard.registerGameBoardObserver(observer -> {
            SwingUtilities.invokeLater(() -> {
                String messageToUser = "You lost this game match!";
                if(observer.isGameMatchWonByUser()){
                    messageToUser = "You won this game match!";
                }
                JOptionPane.showMessageDialog(this, messageToUser);
                gameBoard.restartBoardGame();
            });
        });
    }
}
