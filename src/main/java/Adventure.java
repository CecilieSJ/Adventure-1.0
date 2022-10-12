import java.util.ArrayList;

import ENUM.Attack;
import ENUM.EatFood;
import ENUM.EquipItem;

public class Adventure {
    private Map map = new Map();
    private Player player = new Player();


    public Adventure() {
        player.setCurrentRoom(map.getStartRoom());
        //player.setCurrentWeapon();

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
        return player.addLife();
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

    /*public ArrayList<Item> allWeaponList() {
        return player.getWeaponList();
    }*/


    public String getWeapon() {
        return player.getWeapon();
    }

  /*  public Weapon getCurrentweapon() {
        return player.getCurrentWeapon();
    }*/


   /* public Item getEquippedItem(String itemName) {
        return player.getEquippedItem(itemName);
    }*/

    /*public String attack() {
        return player.attack();
    }

*/
    public Weapon getCurrentWeapon() {
        return player.getCurrentWeapon();
    }
    public EquipItem equipItem(String itemName) {
        return player.equipItem(itemName);
    }
    public Item searchItemInv(String itemName) {
        return player.searchItemInv(itemName);
    }
    public EquipItem unEquipItem(String itemName) {
        return player.unEquipItem(itemName);
    }
    public Attack attack(String itemName) {
        return player.attack(itemName);
    }


   /* public Item searchItemInv(String itemName) {
        return player.searchItemInv(itemName);
    }



    public Attack attack(String itemName) {
        return player.attack(itemName);
    }

*/




}








