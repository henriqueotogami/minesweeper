package br.com.otogamidev.minesweeper.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class contains the unit tests of the selected field class.
 * @since 26-06-2022
 * @implNote Class implementation in class 231 of the full Java course.
 * @author henriquematheusalvespereira
 */
public class SelectFieldTest {

    private final int defaultFieldLine = 3;
    private final int defaultFieldColumn = 3;
    private SelectField defaultField;

    /**
     * Method to initialize the default field, which will be used for neighboring field checks.
     * @implNote Lesson 231 - Adding neighbors.
     */
    @BeforeEach
    void startSelectField() {
        defaultField = new SelectField(defaultFieldLine, defaultFieldColumn);
    }

    /**
     * Unit test to verify if a field informed by the row x column position IS A neighbor of another pre-defined field.
     * @implNote Lesson 231 - Adding neighbors.
     */
    void checkSingleNeighbor(final int checkFieldLine, final int checkFieldColumn) {
        SelectField checkField = new SelectField(checkFieldLine, checkFieldColumn);
        boolean checkFieldIsNeighbor = defaultField.checkAndAddNeighbor(checkField);
        assertTrue(checkFieldIsNeighbor);
    }

    @Test
    void checkAroundNeighbors() {
        final int leftFieldLine = 3;
        final int leftFieldColumn = 2;
        final int rightFieldLine = 3;
        final int rightFieldColumn = 4;
        final int topFieldLine = 2;
        final int topFieldColumn = 3;
        final int bottomFieldLine = 4;
        final int bottomFieldColumn = 3;

        final int topLeftFieldLine = 2;
        final int topLeftFieldColumn = 2;
        final int bottomLeftFieldLine = 4;
        final int bottomLeftFieldColumn = 2;
        final int topRightFieldLine = 4;
        final int topRightFieldColumn = 2;
        final int bottomRightFieldLine = 4;
        final int bottomRightFieldColumn = 4;

        checkSingleNeighbor(leftFieldLine, leftFieldColumn);
        checkSingleNeighbor(rightFieldLine, rightFieldColumn);
        checkSingleNeighbor(topFieldLine, topFieldColumn);
        checkSingleNeighbor(bottomFieldLine, bottomFieldColumn);
        checkSingleNeighbor(topLeftFieldLine, topLeftFieldColumn);
        checkSingleNeighbor(bottomLeftFieldLine, bottomLeftFieldColumn);
        checkSingleNeighbor(topRightFieldLine, topRightFieldColumn);
        checkSingleNeighbor(bottomRightFieldLine, bottomRightFieldColumn);
    }

    /**
     * Unit test to verify if a field informed by the row x column position IS NOT a neighbor of another pre-defined
     * field.
     * @implNote Lesson 231 - Adding neighbors.
     */
    void checkSingleNoNeighbor(final int checkFieldLine, final int checkFieldColumn) {
        SelectField checkField = new SelectField(checkFieldLine, checkFieldColumn);
        boolean checkFieldIsNeighbor = defaultField.checkAndAddNeighbor(checkField);
        assertFalse(checkFieldIsNeighbor);
    }

    @Test
    void checkNearbyNoNeighbors() {
        int leftNearbyFieldLine = 1;
        int rightNearbyFieldLine = 1;
        final int leftNearbyFieldColumn = 1;
        final int rightNearbyFieldColumn = 5;

        while(6 > leftNearbyFieldLine) {
            checkSingleNoNeighbor(leftNearbyFieldLine, leftNearbyFieldColumn);
            leftNearbyFieldLine++;
        }

        while(6 > rightNearbyFieldLine) {
            checkSingleNoNeighbor(rightNearbyFieldLine, rightNearbyFieldColumn);
            rightNearbyFieldLine++;
        }
    }

    @Test
    void checkFirstDefaultValueMarkedField(){
        assertFalse(defaultField.isFieldMarked());
    }

    @Test
    void checkSecondDefaultValueMarkedField(){
        defaultField.changeMarkedField();
        defaultField.changeMarkedField();
        assertFalse(defaultField.isFieldMarked());
    }

    @Test
    void checkChangeMarkedField() {
        defaultField.changeMarkedField();
        assertTrue(defaultField.isFieldMarked());
    }

}