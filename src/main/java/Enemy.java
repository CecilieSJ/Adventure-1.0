public class Enemy {

    private String enemyName;
    private String enemyDescription;
    private int enemyHealth;
    private int enemyDamage;
    private Room room;


    public Enemy(String enemyName, String enemyDescription, int enemyHealth, int enemyDamage){
        this.enemyHealth = enemyHealth;
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

    public int getEnemyHealth(){
        return enemyHealth;
    }

    public int getEnemyDamage(){
        return enemyDamage;
    }

    public boolean death(){
        if(enemyHealth>=0){
            room.removeEnemy(enemyName);
            return true;
        }else {
            return false;
        }
    }



}
