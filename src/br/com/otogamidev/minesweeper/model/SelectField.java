package br.com.otogamidev.minesweeper.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the structure of each square selection field in the game, in which the user must take an
 * action by clicking on it, either to open it or mark it to keep it closed.
 * @since 25-06-2022
 * @implNote Class implementation in class 228 of the full Java course.
 * @author henriquematheusalvespereira
 */
public class SelectField {

    private final int fieldLine;
    private final int fieldColumn;

    private boolean fieldOpen;
    private boolean fieldUndermine;
    private boolean fieldMarked;

    private List<SelectField> fieldNeighbors = new ArrayList<>();

    SelectField(final int fieldLine, final int fieldColumn) {
        this.fieldLine = fieldLine;
        this.fieldColumn = fieldColumn;
    }

    /**
     * Check if the field, representing the informed neighbor, is really a neighbor.
     * @param neighbor Field informed as neighbor to be checked.
     * @return If yes, it returns true and adds the informed neighbor, and if not, it returns false.
     * @implNote Lesson 231 - Adding neighbors.
     */
    boolean checkAndAddNeighbor(final SelectField neighbor) {
        boolean differentLine = (fieldLine != neighbor.fieldLine);
        boolean differentColumn = (fieldColumn != neighbor.fieldColumn);
        boolean diagonalLine = (differentLine && differentColumn);

        int deltaLine = Math.abs(fieldLine - neighbor.fieldLine);
        int deltaColumn = Math.abs(fieldColumn - neighbor.fieldColumn);
        int deltaTotal = (deltaLine + deltaColumn);

        if(deltaTotal == 1 && !diagonalLine){
            fieldNeighbors.add(neighbor);
            return true;
        } else if (deltaTotal == 2 && diagonalLine) {
            fieldNeighbors.add(neighbor);
            return true;
        } else {
            return false;
        }
    }
}
