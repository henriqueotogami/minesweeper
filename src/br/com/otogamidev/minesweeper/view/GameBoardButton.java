package br.com.otogamidev.minesweeper.view;

import br.com.otogamidev.minesweeper.model.BoardField;
import br.com.otogamidev.minesweeper.model.BoardFieldEvents;
import br.com.otogamidev.minesweeper.model.BoardFieldObserver;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class GameBoardButton extends JButton implements BoardFieldObserver {

    private BoardField boardField;

    private final Color BOARDFIELD_DEFAULT_BACKGROUND = new Color(184,184,184);
    private final Color BOARDFIELD_TO_MARK_BACKGROUND = new Color(9,179,247);
    private final Color BOARDFIELD_TO_EXPLODE_BACKGROUND = new Color(189,66,68);
    private final Color GREEN_TEXT = new Color(0,100,0);

    public GameBoardButton(final BoardField boardField) {
        this.boardField = boardField;
        setBackground(BOARDFIELD_DEFAULT_BACKGROUND);
        setBorder(BorderFactory.createBevelBorder(0));
        boardField.registerObserver(this);
    }

    @Override
    public void eventOccurred(BoardField boardField, BoardFieldEvents boardFieldEvents) {
        switch(boardFieldEvents) {
            case TO_OPEN:
                applyBoardFieldOpeningStyle();
                break;
            case TO_MARK_ON:
                applyBoardFieldMarkingStyle();
                break;
            case TO_EXPLODE:
                applyBoardFieldExplodeStyle();
            default:
                applyBoardFieldDefaultStyle();
        }
    }

    private void applyBoardFieldOpeningStyle() {

    }

    private void applyBoardFieldMarkingStyle() {

    }

    private void applyBoardFieldExplodeStyle(){

    }

    private void applyBoardFieldDefaultStyle(){

    }
}
