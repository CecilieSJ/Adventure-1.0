import java.util.ArrayList;

public class Player {

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


    public int getLife(){
        return life;
    }

    public void setLife(int life){
        this.life = life;
    }


    public ArrayList<Item>getInventory(){
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

}
