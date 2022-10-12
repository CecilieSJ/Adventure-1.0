public class Enemy {

    private String enemyName;
    private String enemyDescription;
    private int health;
    private int enemyDamage;
    private Room room;


    public Enemy(String enemyName, String enemyDescription, int enemyHealth, int enemyDamage){
        this.health = enemyHealth;
        this.enemyName = enemyName;
        this.enemyDescription = enemyDescription;
        this.enemyDamage = enemyDamage;

    }

    public String getEnemyName(){
        return enemyName;
    }

    public String getEnemyDescription(){
        return enemyDescription;
    }

    public int getHealth(){
        return health;
    }

    public int getEnemyDamage(){
        return enemyDamage;
    }

    public boolean death(){
        if(health >=0){
            room.removeEnemy(enemyName);
            return true;
        }else {
            return false;
        }
    }
    public void currentHealth(int damage) {
        health -= damage;
    }
    @Override
    public String toString() {
        return enemyName + enemyDescription + health;
    }




}
