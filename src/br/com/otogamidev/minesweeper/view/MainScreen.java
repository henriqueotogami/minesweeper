package br.com.otogamidev.minesweeper.view;

import br.com.otogamidev.minesweeper.model.GameBoard;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class MainScreen extends JFrame {

    public MainScreen() throws HeadlessException {
        GameBoard gameBoard = new GameBoard(16,30,50);
        add(new GameBoardPanel(gameBoard));

        setTitle("Minesweeper");
        final int screenWidth = 690;
        final int screenHeight = 438;
        setSize(screenWidth, screenHeight);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        final Component screenCentralizedOnDesktop = null;
        setLocationRelativeTo(screenCentralizedOnDesktop);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainScreen();
    }
}
