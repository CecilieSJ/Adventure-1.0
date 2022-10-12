import java.util.ArrayList;

public class Player {

    private Room currentRoom;
    private Weapon currentWeapon;
    private int health;
    private int life = 100;
    private String weapon;
    private ArrayList<Item> inventory = new ArrayList<>();
    private ArrayList<Item> weaponList = new ArrayList<>();


    public ArrayList<Item> getWeaponList() {
        for (Item ll : inventory)
            if (ll instanceof Weapon)
                weaponList.add(ll);


        return weaponList;

    }


    public Item takeItem(String itemName) {
        for (Item item : currentRoom.getItemList()) {
            if (item.getItemName().equals(itemName)) {
                inventory.add(item);
                currentRoom.getItemList().remove(item);
                return item;
            }
        }
        return null;
    }

    public Item dropItem(String itemName) {
        for (Item item : inventory) {
            if (item.getItemName().equals(itemName)) {
                inventory.remove(item);
                currentRoom.getItemList().add(item);
                return item;
            }

        }
        return null;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }


    public boolean move(char direction) {
        Room requestedRoom = null;

        if (direction == 'n') {
            requestedRoom = currentRoom.getNorth();
        } else if (direction == 'e') {
            requestedRoom = currentRoom.getEast();
        } else if (direction == 's') {
            requestedRoom = currentRoom.getSouth();
        } else if (direction == 'w') {
            requestedRoom = currentRoom.getWest();
        }

        if (requestedRoom != null) {
            currentRoom = requestedRoom;
            return true;
        } else {
            return false;
        }
    }

    public int getHealth() {
        return health;
    }

    public int getLife() {
        return life;
    }


    public void setLife(int life) {
        this.life = life;
    }


    public Item equip(Weapon weapon) {
        return currentWeapon;
    }


    public String attack(String itemName) {
        Item weapon = currentWeapon;
        if(weapon != null){
            if(weapon instanceof MeleeWeapon meleeWeapon){
                (meleeWeapon).getDamage();
                return "Attack Melee";
            } else if (weapon instanceof RangedWeapon rangedWeapon && rangedWeapon.canUse()) {
                (rangedWeapon).getDamage();
                (rangedWeapon).useAmmo();
                return "Attack rangedweapon";

            }else{
                return "No ammo";
            }
        }if (currentWeapon == null){
            return "No weapon";
        }
        return null;

    }

    public String getWeapon() {
        return weapon;

    }

    public Item getEquippedItem(String name){
        for(Item item : weaponList){
            if (item.getItemName().equals(name)) {
                item = currentWeapon;
                return currentWeapon;
            }
        }
        return null;
    }


}


    /*public ReturnMessage eat(Food foodName) {
        Item eatItem = takeItem(foodName.getItemName());
        if (eatItem == null) {
            return ReturnMessage.NOT_FOUND;
        }
        if (eatItem instanceof Food) {
            inventory.remove(foodName);
            return ReturnMessage.OK;
        } else {
            return ReturnMessage.CANT;
        }

     */








