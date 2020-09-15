package Chess;

public class Player {
    private int id;
    private String name;

    Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
