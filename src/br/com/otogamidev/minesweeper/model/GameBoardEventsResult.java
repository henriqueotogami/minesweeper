package br.com.otogamidev.minesweeper.model;

public class GameBoardEventsResult {

    private final boolean gameMatchWonByUser;

    public GameBoardEventsResult(final boolean gameMatchWonByUser) {
        this.gameMatchWonByUser = gameMatchWonByUser;
    }

    public boolean isGameMatchWonByUser() {
        return gameMatchWonByUser;
    }
}
