public class Room {

    private String name;
    private String beskrivelsen;
    private Room north;
    private Room west;
    private Room south;
    private Room east;


    public Room(String name, String beskrivelsen){
        this.name = name;
        this.beskrivelsen = beskrivelsen;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }


    public String getBeskrivelsen(){
        return beskrivelsen;
    }
    public void setBeskrivelsen(String beskrivelsen){
        this.beskrivelsen = beskrivelsen;
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

