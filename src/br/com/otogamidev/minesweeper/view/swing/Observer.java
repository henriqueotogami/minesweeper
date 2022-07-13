package br.com.otogamidev.minesweeper.view.swing;

import javax.swing.*;
import java.awt.*;

public class Observer {

    public static void main(String[] args) {

        JFrame window = new JFrame("Observer");

        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(600,200);
        window.setLayout(new FlowLayout());
        final Component windowCentralizedOnDesktop = null;
        window.setLocationRelativeTo(windowCentralizedOnDesktop);

        JButton button = new JButton("OK");
        window.add(button);
        button.addActionListener(eventOccurred -> { System.out.println("Event occurred."); });
        window.setVisible(true);
    }
}
