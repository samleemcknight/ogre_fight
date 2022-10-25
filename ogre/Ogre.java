package ogre;
import fighter.Fighter;
import weapon.Claws;

public class Ogre extends Fighter {
    public Ogre() {
        super(new Claws(), 55, 1);
        this.equippedWeapon = super.equippedWeapon;
        this.healthPoints = super.healthPoints;
    }

    public int attack() {
        int maxDamage = this.equippedWeapon.maxDamage;
        int minDamage = this.equippedWeapon.minDamage;
        int attackDamage = (int)Math.floor(Math.random()*(maxDamage-minDamage)+minDamage);
        return attackDamage;
    }
}