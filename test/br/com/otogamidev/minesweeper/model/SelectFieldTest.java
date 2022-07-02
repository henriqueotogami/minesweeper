package br.com.otogamidev.minesweeper.model;

import br.com.otogamidev.minesweeper.exception.ExplosionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class contains the unit tests of the selected field class.
 * @since 26-06-2022
 * @implNote Class implementation in lecture 231 of the full Java course.
 * @author henriquematheusalvespereira
 */
public class SelectFieldTest {

    private final int defaultFieldLine = 3;
    private final int defaultFieldColumn = 3;
    private SelectField defaultField;

    /**
     * Method to initialize the default field, which will be used for neighboring field checks.
     * @implNote Lecture 231 - Adding neighbors.
     */
    @BeforeEach
    void startSelectField() {
        defaultField = new SelectField(defaultFieldLine, defaultFieldColumn);
    }

    /**
     * Method to verify if a field informed by the row x column position IS A neighbor of another pre-defined field.
     * @implNote Lecture 231 - Adding neighbors.
     */
    void checkSingleNeighbor(final int checkFieldLine, final int checkFieldColumn) {
        SelectField checkField = new SelectField(checkFieldLine, checkFieldColumn);
        boolean checkFieldIsNeighbor = defaultField.checkAndAddNeighbor(checkField);
        assertTrue(checkFieldIsNeighbor);
    }

    /**
     * Unit test to verify the logic adopted from neighboring fields of a pre-defined field.
     * @implNote Lecture 231 - Adding neighbors.
     */
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
     * Method to verify if a field informed by the row x column position IS NOT a neighbor of another pre-defined
     * field.
     * @implNote Lecture 231 - Adding neighbors.
     */
    void checkSingleNoNeighbor(final int checkFieldLine, final int checkFieldColumn) {
        SelectField checkField = new SelectField(checkFieldLine, checkFieldColumn);
        boolean checkFieldIsNeighbor = defaultField.checkAndAddNeighbor(checkField);
        assertFalse(checkFieldIsNeighbor);
    }

    /**
     * Unit test to verify the adopted logic of nearby fields, which are not neighbors, of a pre-defined field.
     * @implNote Lecture 231 - Adding neighbors.
     */
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

    /**
     * Unit test to verify that the default value of a marked field is false.
     * @implNote Lecture 233 - Implementation of the selection field class and unit tests.
     */
    @Test
    void checkFirstDefaultValueMarkedField(){
        assertFalse(defaultField.isFieldMarked());
    }

    /**
     * Unit test to check the marking and deselection of a field.
     * @implNote Lecture 233 - Implementation of the selection field class and unit tests.
     */
    @Test
    void checkSecondDefaultValueMarkedField(){
        defaultField.changeMarkedField();
        defaultField.changeMarkedField();
        assertFalse(defaultField.isFieldMarked());
    }

    /**
     * Unit test to check the marking of a field.
     * @implNote Lecture 233 - Implementation of the selection field class and unit tests.
     */
    @Test
    void checkChangeMarkedField() {
        defaultField.changeMarkedField();
        assertTrue(defaultField.isFieldMarked());
    }

    /**
     * Unit test to verify the safe opening of a field that is not mined and not marked.
     * @implNote Lecture 233 - Implementation of the selection field class and unit tests.
     */
    @Test
    void checkOpenSafeField(){
        assertFalse(defaultField.isFieldUndermine());
        assertFalse(defaultField.isFieldMarked());
        assertTrue(defaultField.openField());
    }

    /**
     * Unit test to verify the opening of a field that is only marked.
     * @implNote Lecture 233 - Implementation of the selection field class and unit tests.
     */
    @Test
    void checkOpenMarkedField(){
        defaultField.changeMarkedField();
        assertTrue(defaultField.isFieldMarked());
        assertFalse(defaultField.openField());
    }

    /**
     * Unit test to verify the opening of a field that is marked and mined.
     * @implNote Lecture 233 - Implementation of the selection field class and unit tests.
     */
    @Test
    void checkOpenMarkedAndUnderminedField(){
        defaultField.changeMarkedField();
        assertTrue(defaultField.isFieldMarked());
        defaultField.setFieldUndermine(true);
        assertTrue(defaultField.isFieldUndermine());
        assertFalse(defaultField.openField());
    }

    /**
     * Unit test to verify the opening of a minefield.
     * @implNote Lecture 233 - Implementation of the selection field class and unit tests.
     */
    @Test
    void checkOpenUnderminedField(){
        defaultField.setFieldUndermine(true);
        assertTrue(defaultField.isFieldUndermine());
        assertThrows(ExplosionException.class, () -> { defaultField.openField(); });
    }

    /**
     * Unit test to verify the opening of multiple fields, neighbors and near.
     * @implNote Lecture 233 - Implementation of the selection field class and unit tests.
     */
    @Test
    void checkOpenMultipleNeighboringFields(){
        SelectField topLeftNeighborOfMyTopLeftNeighborField = new SelectField(1,1);
        SelectField myTopLeftNeighborField = new SelectField(2,2);
        myTopLeftNeighborField.checkAndAddNeighbor(topLeftNeighborOfMyTopLeftNeighborField);

        defaultField.checkAndAddNeighbor(myTopLeftNeighborField);
        assertTrue(defaultField.openField());
        assertTrue((myTopLeftNeighborField.isFieldOpen()) && (topLeftNeighborOfMyTopLeftNeighborField.isFieldOpen()));
    }

    /**
     * Unit test to verify the opening of multiple fields, neighbors and near, and that are mined.
     * @implNote Lecture 233 - Implementation of the selection field class and unit tests.
     */
    @Test
    void checkOpenMultipleNeighboringUnderminedFields(){
        SelectField topLeftNeighborOfMyTopLeftNeighborField = new SelectField(1,1);
        SelectField topNeighborOfMyTopLeftNeighborField = new SelectField(1,2);
        SelectField myTopLeftNeighborField = new SelectField(2,2);

        topNeighborOfMyTopLeftNeighborField.setFieldUndermine(true);
        myTopLeftNeighborField.checkAndAddNeighbor(topLeftNeighborOfMyTopLeftNeighborField);
        myTopLeftNeighborField.checkAndAddNeighbor(topNeighborOfMyTopLeftNeighborField);

        defaultField.checkAndAddNeighbor(myTopLeftNeighborField);
        defaultField.openField();
        assertTrue(myTopLeftNeighborField.isFieldOpen());
        assertTrue(topLeftNeighborOfMyTopLeftNeighborField.isFieldClosed());
    }
}