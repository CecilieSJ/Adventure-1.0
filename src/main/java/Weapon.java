public abstract class Weapon extends Item{

    private String weapon;
    private int damage;

    public Weapon(String itemName, String itemDescription,String weapon, int damage){
        super(itemName, itemDescription);
        this.weapon = weapon;
    }


    public int getDamage(){
        return damage;
    }
    public abstract void useAmmo();

    public abstract int getAmmunition();
    public abstract Boolean canUse();

}
