package br.com.otogamidev.minesweeper.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Implementation of the class that represents the game board, which will contain the user selection fields, which
 * will contain bombs or be empty.
 * @since 25-06-2022
 * @implNote Class implementation in lecture 228 of the full Java course.
 * @author henriquematheusalvespereira
 */
public class GameBoard implements BoardFieldObserver {

    private int boardLines;
    private int boardColumns;
    private int boardUndermines;

    private final List<BoardField> boardFields = new ArrayList<BoardField>();
    private final List<Consumer<GameBoardEventsResult>> gameBoardObservers = new ArrayList<>();

    /**
     * Constructor method that is responsible for generating the game board selection fields, mapping neighboring
     * fields and minefields to a selected field.
     * @param boardLines Total number of lines on the board.
     * @param boardColumns Total number of columns on the board.
     * @param boardUndermines Total number of undermines on the board.
     */
    public GameBoard(final int boardLines, final int boardColumns, final int boardUndermines) {
        this.boardLines = boardLines;
        this.boardColumns = boardColumns;
        this.boardUndermines = boardUndermines;

        generateBoardFields();
        mappingBoardNeighborhood();
        raffleBoardUndermines();
    }

    /**
     * @return An integer representing the number of lines on the game board.
     */
    private int getBoardLines() { return boardLines; }

    /**
     * @param boardLines Define an integer representing the number of lines on the game board.
     */
    private void setBoardLines(final int boardLines) { this.boardLines = boardLines; }

    /**
     * @return An integer representing the number of columns on the game board.
     */
    private int getBoardColumns() { return boardColumns; }

    /**
     * @param boardColumns Define an integer representing the number of columns on the game board.
     */
    private void setBoardColumns(final int boardColumns) { this.boardColumns = boardColumns; }

    /**
     * @return Returns an integer representing the number of undermines on the game board.
     */
    private int getBoardUndermines() { return boardUndermines; }

    /**
     * @param boardUndermines Returns an integer representing the number of undermines on the game board.
     */
    private void setBoardUndermines(final int boardUndermines) { this.boardUndermines = boardUndermines; }

    /**
     * @return A list containing the defined fields of the board, sorted using rows and columns.
     */
    private List<BoardField> getBoardFields() { return boardFields; }

    public List<Consumer<GameBoardEventsResult>> getGameBoardObservers() { return gameBoardObservers; }

    /**
     * Method that generates all selection fields on the game board.
     */
    private void generateBoardFields(){
        for(int indexLine = 0; getBoardLines() > indexLine; indexLine++) {
            for(int indexColumn = 0; getBoardColumns() > indexColumn; indexColumn++){
                final BoardField newBoardField = new BoardField(indexLine, indexColumn);
                newBoardField.registerObserver(this);
                getBoardFields().add(newBoardField);
            }
        }
    }

    /**
     * Method that maps all fields neighboring the selection field on the game board.
     */
    private void mappingBoardNeighborhood() {
        for(BoardField boardSelectedField: getBoardFields()){
            for(BoardField boardNeighborField: getBoardFields()) {
                boardSelectedField.checkAndAddNeighbor(boardNeighborField);
            }
        }
    }

    /**
     * Method that draws all fields with mines on the game board.
     */
    private void raffleBoardUndermines() {
        long underminesArmed = 0;
        Predicate<BoardField> boardFieldsUndermined = (boardField -> boardField.isFieldUndermine());

        do {
            int fieldUnderminedRandom = (int) (Math.random() * getBoardFields().size());
            underminesArmed = getBoardFields().stream().filter(boardFieldsUndermined).count();
            getBoardFields().get(fieldUnderminedRandom).setFieldUndermine(true);
        } while((getBoardUndermines()-1) > underminesArmed);

    }

    /**
     * @return True if the selected board fields have been opened and securely marked.
     */
    public boolean safeBoardFieldObjective() {
        return getBoardFields().stream().allMatch(boardField -> boardField.safeFieldObjective());
    }

    /**
     * Method to restart the game.
     */
    public void restartBoardGame() {
        getBoardFields().stream().forEach(boardField -> boardField.resetSelectedField());
        raffleBoardUndermines();
    }

    /**
     * @return Returns the game board in text format to be printed on the console.
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        final String EMPTY_SPACE = " ";
        final String NEW_LINE = "\n";

        stringBuilder.append(EMPTY_SPACE);
        for(int indexColumnHeader = 0; getBoardColumns() > indexColumnHeader; indexColumnHeader++) {
            stringBuilder.append(EMPTY_SPACE);
            stringBuilder.append(indexColumnHeader);
            stringBuilder.append(EMPTY_SPACE);
        }
        stringBuilder.append(NEW_LINE);

        int indexField = 0;
        for(int indexLineField = 0; getBoardLines() > indexLineField; indexLineField++) {
            stringBuilder.append(indexLineField);
            stringBuilder.append(EMPTY_SPACE);
            for(int indexColumnField = 0; getBoardColumns() > indexColumnField; indexColumnField++){
                stringBuilder.append(EMPTY_SPACE);
                stringBuilder.append(getBoardFields().get(indexField));
                stringBuilder.append(EMPTY_SPACE);
                indexField++;
            }
            stringBuilder.append(NEW_LINE);
        }

        return stringBuilder.toString();
    }

    /**
     * Method to open the selected minefield.
     * @param boardLine Whole number representing the board line.
     * @param boardColumn Whole number representing the board column.
     */
    public void openBoardField(final int boardLine, final int boardColumn) {
        getBoardFields().parallelStream()
                .filter(boardField -> ((boardField.getFieldLine() == boardLine) && (boardField.getFieldColumn() == boardColumn)))
                .findFirst()
                .ifPresent(boardField -> boardField.openField());
    }

    private void showGameBoardUndermines() {
        getBoardFields().stream()
                .filter(boardField -> boardField.isFieldUndermine())
                .forEach(boardField -> boardField.setFieldOpen(true));
    }

    /**
     * Method to change the state of the selected minefield.
     * @param boardLine Whole number representing the board line.
     * @param boardColumn Whole number representing the board column.
     */
    public void changeMarkedBoardField(final int boardLine, final int boardColumn) {
        getBoardFields().parallelStream()
                .filter(boardField -> ((boardField.getFieldLine() == boardLine) && (boardField.getFieldColumn() == boardColumn)))
                .findFirst()
                .ifPresent(boardField -> boardField.changeMarkedField());
    }

    public void registerGameBoardObserver(final Consumer<GameBoardEventsResult> gameBoardObserver ){
        getGameBoardObservers().add(gameBoardObserver);
    }

    private void notifyGameBoardObservers(final boolean gameBoardEventOccurred){
        getGameBoardObservers().stream()
                .forEach(gameBoardObserver -> gameBoardObserver.accept(new GameBoardEventsResult(gameBoardEventOccurred)));
    }

    @Override
    public void eventOccurred(final BoardField boardField, final BoardFieldEvents boardFieldEvents) {
        if(boardFieldEvents == BoardFieldEvents.TO_EXPLODE){
            showGameBoardUndermines();
            notifyGameBoardObservers(false);
        } else if(safeBoardFieldObjective()){
            notifyGameBoardObservers(true);
        }
    }


}
