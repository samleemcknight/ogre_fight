package fighter;
import weapon.Weapon;

public class Fighter {
    public Weapon equippedWeapon;
    public int healthPoints;
    public int level;
    public String fighterType;
    
    public Fighter(Weapon weapon, int healthPoints, int level, String fighterType) {
        this.equippedWeapon = weapon;
        this.healthPoints = healthPoints;
        this.level = level;
        this.fighterType = fighterType;
    }

    public int attack() {
        int maxDamage = this.equippedWeapon.maxDamage;
        int minDamage = this.equippedWeapon.minDamage;
        int attackDamage = (int)Math.floor(Math.random()*(maxDamage-minDamage)+minDamage);
        return attackDamage;
    }

    public void loseGame() {
        System.out.println("The " + this.fighterType + " has been defeated");
    }

    public void winGame() {
        System.out.println("The " + this.fighterType + " is victorious!");
    }

    public void takeDamage(int damage) {
        int currentHP = this.healthPoints;
        int newHP = currentHP - damage;
        this.healthPoints = newHP;
        if (this.healthPoints <= 0) {
            this.loseGame();
        }
    }
}