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

    public int addLife() {
        return player.getHealth() + player.getLife();
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
    public ArrayList<Item> allWeaponList() {
        return player.getWeaponList();
    }



    public String getWeapon() {
        return player.getWeapon();
    }

    public Item CurrentWeapon(Weapon weapon){
        return player.equip(weapon);
    }
    



public Item getEquippedItem(String itemName){
        return player.getEquippedItem(itemName);
}

    public String attack(String itemName) {
        return player.attack(itemName);
    }


}





    /* public ReturnMessage eat(String foodName) {
         Item itemInventory = player.takeItem(foodName);
         if (itemInventory == null) {
             return ReturnMessage.NOT_FOUND;
         }
         if (itemInventory instanceof Food food) {
             player.eat(food);
             int points = player.getLife() + player.getHealth();
             getPlayer().setLife(points);
             return ReturnMessage.OK;
         } else {
             return ReturnMessage.CANT;
         }
     }
*/







