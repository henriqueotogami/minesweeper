package br.com.otogamidev.minesweeper.model;

public interface BoardFieldObserver {

    public void eventOccurred(final BoardField boardField, final BoardFieldEvents eventSelectedField);
}
