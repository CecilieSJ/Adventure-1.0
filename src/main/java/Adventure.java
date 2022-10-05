import java.util.ArrayList;

public class Adventure {
    private Map map = new Map();
    private Player player = new Player();


    public Adventure() {
        player.setCurrentRoom(map.getStartRoom());

    }

    public Item takeItem(String itemName) {
        return player.takeItem(itemName);
    }
    public Item dropItem(String itemName) {
        return player.dropItem(itemName);
    }

    public Player getPlayer() {
        return player;
    }
    public int getLife() {
        return player.getLife();
    }
    public int addLife() {
        return player.getLife();
    }
    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }
    public Room getStartRoom() {
        return map.getStartRoom();
    }



    public boolean go(String userChoice) {
        return player.move(userChoice.charAt(0));
    }
    public ArrayList<Item> allInventory() {
        return player.getInventory();
    }
      /*public ReturnMessage eat(String foodName){
        Item item = player.takeItem(foodName);
        if(item == null){
            return ReturnMessage.NOT_FOUND;
        } if (item instanceof Food food){
            player.eat(food);
            return ReturnMessage.OK;
        }else {
            return ReturnMessage.CANT;
        }
    }*/



}


