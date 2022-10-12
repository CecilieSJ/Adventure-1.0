public class RangedWeapon extends Weapon {

    public int ammunition;

    public RangedWeapon(String itemName, String itemDescription, String weapon, int damage, int ammunition) {
        super(itemName, itemDescription, weapon, damage);
        this.ammunition = ammunition;
    }

    public int getAmmunition() {
        return ammunition;
    }

    public Boolean canUse() {
        if (ammunition <= 0) {
            return false;
        } else {
            return true;
        }
    }


    public void useAmmo() {
        ammunition--;
    }



}