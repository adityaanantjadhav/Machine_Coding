public class Player {
    private int id;
    private String name;

    public Player(String playerName,int id){
        this.id=id;
        this.name=playerName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
