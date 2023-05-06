package be.thomasmore.qrace.model;

public class GameModel {
    private String scanner;
    private int points;
    private String scoreboard;
    private boolean isGameStarted;


    public GameModel() {
    }


    public String getScanner() {
        return scanner;
    }

    public int getPoints() {
        return points;
    }

    public String getScoreboard() {
        return scoreboard;
    }

    public boolean isGameStarted() {
        return isGameStarted;
    }


    public void setScanner(String scanner) {
        this.scanner = scanner;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setScoreboard(String scoreboard) {
        this.scoreboard = scoreboard;
    }

    public void setGameStarted(boolean gameStarted) {
        isGameStarted = gameStarted;
    }
}
