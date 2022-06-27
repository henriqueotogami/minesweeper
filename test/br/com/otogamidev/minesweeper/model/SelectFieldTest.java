package br.com.otogamidev.minesweeper.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelectFieldTest {

    private final int firstFieldLine = 3;
    private final int firstFieldColumn = 3;
    private SelectField selectField = new SelectField(firstFieldLine, firstFieldColumn);

    @Test
    void checkFirstNeighbor() {
        SelectField newField = new SelectField(firstFieldLine, 2);
        boolean newFieldIsNeighbor = selectField.checkAndAddNeighbor(newField);
        assertTrue(newFieldIsNeighbor);
    }

}