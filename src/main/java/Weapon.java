public class Weapon extends Item{

    private String weapon;
    private int damage;

    public Weapon(String itemName, String itemDescription,String weapon, int damage){
        super(itemName, itemDescription);
        this.weapon = weapon;
    }

    public String getWeapon(){
        return weapon;
    }

    public int getDamage(){
        return damage;
    }
}
