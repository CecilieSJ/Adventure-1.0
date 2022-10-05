import java.util.ArrayList;

public class Player{

    private Room currentRoom;
    private int life = 100;
    private ArrayList<Item> inventory = new ArrayList<>();


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

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void addToHealth(int healthValue){
        this.life += healthValue;
        if(life>100){
            this.life = 100;
        }
        if(life<0){
            this.life = 0;
        }
    }

    public int eat(Food food){
        addToHealth(food.getHealth());
        return food.getHealth();
    }


    /*public Item eat(Food food) {
        Item item = takeItem(food.getItemName());
        if(item == null){
            return ReturnMessage.NOT_FOUND;
        } if (item instanceof Food food){
            player.eat(food);
            return ReturnMessage.OK;
        }else {
            return ReturnMessage.CANT;
        }

    }*/


   /* public void ReturnMessage(String foodName) {
        NOT_FOUND;
        OK;
        CANT;

    }*/


}
