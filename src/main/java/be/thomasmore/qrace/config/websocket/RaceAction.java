package be.thomasmore.qrace.config.websocket;

public class RaceAction {
    private int raceId;
    private int playerId;
    private String scannedQRCode;
    private String answer;
    private boolean firstTry;

    // Constructors, getters, and setters

    public RaceAction() {
    }

    public RaceAction(int raceId, int playerId, String scannedQRCode, String answer, boolean firstTry) {
        this.raceId = raceId;
        this.playerId = playerId;
        this.scannedQRCode = scannedQRCode;
        this.answer = answer;
        this.firstTry = firstTry;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getScannedQRCode() {
        return scannedQRCode;
    }

    public void setScannedQRCode(String scannedQRCode) {
        this.scannedQRCode = scannedQRCode;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isFirstTry() {
        return firstTry;
    }

    public void setFirstTry(boolean firstTry) {
        this.firstTry = firstTry;
    }
}
