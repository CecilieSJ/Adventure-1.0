public class RangedWeapon extends Weapon{

  public int shots;

    public RangedWeapon(String itemName, String itemDescription, String weapon, int damage, int shots){
        super(itemName, itemDescription,weapon, damage);
        this.shots = shots;
    }



}
