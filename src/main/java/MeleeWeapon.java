public class MeleeWeapon extends  Weapon{


    public MeleeWeapon(String itemName, String itemDescription, String weapon, int damage){
        super(itemName, itemDescription,weapon, damage);
        
    }

    public Boolean canUse() {
        return true;
    }

    @Override
    public void useAmmo() {
    }


    @Override
    public int getAmmunition() {
        return 0;
    }

}

