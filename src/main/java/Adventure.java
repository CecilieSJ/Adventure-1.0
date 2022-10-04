import java.util.ArrayList;

public class Adventure {
    private Map map = new Map();
    private Player player = new Player();


    public Adventure() {
     player.setCurrentRoom(map.getStartRoom());

    }
    public Player getPlayer() {
        return player;
    }

    public Item takeItem(String itemName){
        return player.takeItem(itemName);
    }
    public Item dropItem(String itemName){
        return player.dropItem(itemName);
    }

     public int getPlayerhealth(){
        return player.getLife();
     }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }
    public Room getStartRoom() {
        return map.getStartRoom();
    }

    public boolean go(char direction) {
        return player.move(direction);
    }
    public boolean go(String userChoice) {
     return player.move(userChoice.charAt(0));
    }

    public ArrayList<Item> allInventory() {
        return player.getInventory();
    }






}


