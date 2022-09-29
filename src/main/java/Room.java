import java.util.ArrayList;

public class Room {

    private String name;
    private String description;
    private Room north;
    private Room west;
    private Room south;
    private Room east;
    private ArrayList<Item> items = new ArrayList<>();


    public void addItem(String itemName){
        Item itemList = new Item(itemName);
        items.add(itemList);
    }


    public Room(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }


    public Room getNorth(){
        return north;
    }
    public void setNorth(Room north){
        this.north = north;
    }


    public Room getWest(){
        return west;
    }
    public void setWest(Room west) {
        this.west = west;
    }


    public Room getSouth(){
        return south;
    }
    public void setSouth(Room south) {
        this.south = south;
    }



    public Room getEast(){
        return east;
    }
    public void setEast(Room east) {
        this.east = east;
    }
}

