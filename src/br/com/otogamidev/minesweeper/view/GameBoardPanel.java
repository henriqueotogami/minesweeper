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
            // TODO Implementar retorno para o usuario
        });
    }
}
