import java.util.ArrayList;

import ENUM.Attack;
import ENUM.EatFood;
import ENUM.EquipItem;

public class Player {

    private Room currentRoom;
    private Weapon currentWeapon;
    private int health;
    private int life = 100;
    private String weapon;
    private ArrayList<Item> inventory = new ArrayList<>();
    // private ArrayList<Item> weaponList = new ArrayList<>();



  /*  public ArrayList<Item> getWeaponList() {
        for (Item ll : inventory)
            if (ll instanceof Weapon)
                weaponList.add(ll);


        return weaponList;

    }*/


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
    public int addLife() {
        return getHealth() + getLife();
    }
    public void currentHealth(int damage) {
        health -= damage;
    }



   /* public void setCurrentWeapon() {
        this.currentWeapon = currentWeapon;
    }*/


    public String getWeapon() {
        return weapon;

    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public Item searchItemInv(String itemName) {
        for (Item item : inventory) {
            if (item.getItemName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    public EquipItem equipItem(String itemName) {
        Item invenstory = searchItemInv(itemName);
        if (invenstory != null) {
            if (invenstory instanceof Weapon weapon) {
                dropItem(itemName);
                currentWeapon = weapon;
                return EquipItem.EQUIPPING_WEAPON;
            } else {
                return EquipItem.NOT_WEAPON;
            }
        } else {
            return EquipItem.NOT_FOUND;
        }
    }
    public void removeWeapon(String itemName) {
        currentWeapon = null;
    }
    public EquipItem unEquipItem(String itemName) {
        Weapon equippedWeapon = currentWeapon;
        if (equippedWeapon != null) {

            removeWeapon(itemName);
            inventory.add(equippedWeapon);
            return EquipItem.UNEQUIP;
        } else {
            return EquipItem.NOT_FOUND;
        }
    }


    public Attack attack(String itemName) {
        Weapon weapon = currentWeapon;
        Enemy enemy = currentRoom.searchEnemy(itemName);
        if (weapon == null) {
            return Attack.NOT_EQUIPPED;
        } else if (enemy == null) {
            return Attack.NO_ENEMY;
        } else if (weapon.canUse()) {
            weapon.useAmmo();
            enemy.currentHealth(weapon.getDamage());
            if (!enemy.death()) {
                currentHealth(enemy.getEnemyDamage()); //getCurrentWeapon,getEn
            } else {
                return Attack.KILLED_ENEMY;
            }
            return Attack.ATTACK_ENEMY;
        } else {
            return Attack.NO_AMMO;
        }
    }

}


       /* public EatFood eat(String foodName) {
        Item roomInventory = takeItem(foodName);
        ArrayList<Item> itemInInventory = getInventory();
        if (roomInventory != null) {
            if (roomInventory instanceof Food) {
                int points = addLife();
                setLife(points);
                inventory.remove(foodName);

                return EatFood.YOU_ATE_THE_FOOD;
            } else {
                return EatFood.CANT_EAT_THAT;
            }
        } else {
            return EatFood.NOT_FOUND;

        }

    }*/















