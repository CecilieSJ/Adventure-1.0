public class Enemy {

    private int enemyHealth;

    public Enemy(String enemyName, String enemyDescription, int health, int enemyDamage){
        this.enemyHealth = health;
    }

    public int getEnemyHealth(){
        return enemyHealth;
    }
}
