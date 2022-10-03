import java.util.ArrayList;

public class Adventure {
    private Map map = new Map();
    private Player player = new Player();


    public Adventure() {
     player.setCurrentRoom(map.getStartRoom());
    //player.setInventory(map.getStartRoom().getItemList());
    //player.getRoomInventory();

    }


    public Item getInve
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

