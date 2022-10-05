public class Food extends Item{

    private int health;

    public Food(String itemName, String itemDescription, int health) {
        super(itemName, itemDescription);
        this.health = health;
    }

    public int getHealth(){
        return health;
    }



    @Override
    public String toString(){
       return super.toString() + " " + health;
    }
}
