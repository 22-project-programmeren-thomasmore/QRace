package be.thomasmore.qrace.model;

public class Player {
    private int playerID;
    private String name;


    public Integer getPlayerId() {

        return playerID;
    }

    public void setPlayerId(Integer id) {

        this.playerID = playerID;
    }

    public void setName(String name) {
        this.name = name;
    }
}

