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

    public SelectField(int fieldLine, int fieldColumn) {
        this.fieldLine = fieldLine;
        this.fieldColumn = fieldColumn;
    }
}
