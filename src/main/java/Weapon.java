public class Weapon extends Item{

    private String weapon;
    private int canUse;

    public Weapon(String itemName, String itemDescription,String weapon, int canUse){
        super(itemName, itemDescription);
        this.weapon = weapon;
        this.canUse = canUse;
    }

    public String getWeapon(){
        return weapon;
    }
}
