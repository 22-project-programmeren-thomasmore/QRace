package be.thomasmore.qrace.model;

// de mascottes zijn de verschillende characters binnen QRace
public class Mascot {
    private String name;
    private String description;

    public Mascot(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}