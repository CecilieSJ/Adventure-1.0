import java.util.ArrayList;

public class Adventure {
    private Map map = new Map();
    private Player player = new Player();


    public Adventure() {
     player.setCurrentRoom(map.getStartRoom());

    }

    public boolean takeItem(String itemName){
        return player.takeItem(itemName);
    }
    public boolean dropItem(String itemName){
        return player.dropItem(itemName);
    }
    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    public boolean goNorth() {
        return player.goNorth();
    }

    public boolean goEast() {
        return player.goEast();
    }

    public boolean goSouth() {
        return player.goSouth();
    }

    public boolean goWest() {
        return player.goWest();
    }

    public Room getStartRoom() {
        return map.getStartRoom();
    }
}

