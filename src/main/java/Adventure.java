public class Adventure {
   private Map map;
   private Player player;


   public Adventure(){
       map = new Map();
       player = new Player();
       player.setCurrentRoom(map.getStartRoom());
   }
    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    public boolean goNorth(){
       return player.goNorth();
    }
    public boolean goEast(){
       return player.goEast();
    }

    public boolean goSouth(){
       return player.goSouth();
    }

    public boolean goWest(){
       return player.goWest();
    }

    public Room getStartRoom(){
        return map.getStartRoom();
    }
}

