package fighter;
import weapon.Weapon;

public class Fighter {
    public Weapon equippedWeapon;
    public int healthPoints;
    public int level;
    
    public Fighter(Weapon weapon, int healthPoints, int level) {
        this.equippedWeapon = weapon;
        this.healthPoints = healthPoints;
        this.level = level;
    } 
}