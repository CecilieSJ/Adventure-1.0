import java.util.ArrayList;

public class Player {

    private Room currentRoom;
    private ArrayList<Item> inventory = new ArrayList<>();



    public boolean takeItem(String itemName) {
        for (Item item : currentRoom.getItemList()) {
            if (item.getItemName().equals(itemName)) {
                inventory.add(item);
                currentRoom.getItemList().remove(item);
                return true;
            }
        }
        return false;
    }

    public boolean dropItem(String itemName) {
        for (Item item : inventory) {
            if (item.getItemName().equals(itemName)) {
                inventory.remove(item);
                currentRoom.getItemList().add(item);
                return true;
            }

        }
        return false;
    }


    public ArrayList<Item> inventorySearch(String searchTerm) {
        ArrayList<Item> itemSearch = getCurrentRoom().getItemList();
        for (Item inventoryItem : itemSearch) {
            if (inventoryItem.getItemName().contains(searchTerm.toLowerCase())) {
                itemSearch.add(inventoryItem);
            }

        }
        return itemSearch;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public boolean goNorth() {
        if (currentRoom.getNorth() == null) {
            return false;
        } else {
            currentRoom = currentRoom.getNorth();
            return true;
        }

    }

    public boolean goSouth() {
        if (currentRoom.getSouth() == null) {
            return false;
        } else {
            currentRoom = currentRoom.getSouth();
            return true;
        }
    }

    public boolean goEast() {
        if (currentRoom.getEast() == null) {
            return false;
        } else {
            currentRoom = currentRoom.getEast();
            return true;
        }
    }

    public boolean goWest() {
        if (currentRoom.getWest() == null) {
            return false;
        } else {
            currentRoom = currentRoom.getWest();
            return true;
        }
    }


}
