package br.com.otogamidev.minesweeper.view;

import br.com.otogamidev.minesweeper.model.BoardField;
import br.com.otogamidev.minesweeper.model.BoardFieldEvents;
import br.com.otogamidev.minesweeper.model.BoardFieldObserver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class GameBoardButton extends JButton implements BoardFieldObserver, MouseListener {

    private BoardField boardField;

    private final Color BOARDFIELD_DEFAULT_BACKGROUND = new Color(184,184,184);
    private final Color BOARDFIELD_TO_MARK_BACKGROUND = new Color(9,179,247);
    private final Color BOARDFIELD_TO_EXPLODE_BACKGROUND = new Color(189,66,68);
    private final Color GREEN_TEXT = new Color(0,100,0);

    public GameBoardButton(final BoardField boardField) {
        this.boardField = boardField;
        setBackground(BOARDFIELD_DEFAULT_BACKGROUND);
        setBorder(BorderFactory.createBevelBorder(0));
        addMouseListener(this);
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
        setBackground(BOARDFIELD_DEFAULT_BACKGROUND);
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        switch(boardField.quantityOfUnderminesNeighborhood()){
            case 1:
                setForeground(GREEN_TEXT);
                break;
            case 2:
                setForeground(Color.BLUE);
                break;
            case 3:
                setForeground(Color.YELLOW);
                break;
            case 4:
            case 5:
            case 6:
                setForeground(Color.RED);
                break;
            default:
                setForeground(Color.PINK);
                break;
        }

        String labelUnderminesNeighborhood =
                (boardField.safeNeighborhood() == false) ?
                boardField.quantityOfUnderminesNeighborhood() + "" : "";
        setText(labelUnderminesNeighborhood);
    }

    private void applyBoardFieldMarkingStyle() {

    }

    private void applyBoardFieldExplodeStyle(){

    }

    private void applyBoardFieldDefaultStyle(){

    }

    @Override
    public void mousePressed(final MouseEvent  mouseEvent) {
        if(mouseEvent.getButton() == 1){
            boardField.openField();
        } else {
            boardField.changeMarkedField();
        }
    }


    public void mouseClicked(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}
}
