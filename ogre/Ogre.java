package ogre;
import fighter.Fighter;
import weapon.*;

public class Ogre extends Fighter implements WeaponChoicesOgre {
    public Ogre() {
        super(new Claws(), 55, 1, "ogre");
        this.equippedWeapon = super.equippedWeapon;
        this.healthPoints = super.healthPoints;
    }

    public void switchWeapon(String weaponName) {
        if (weaponName.equals(WeaponChoicesOgre.club)) {
            this.equippedWeapon = new Club();
        } else if (weaponName.equals(WeaponChoicesOgre.rock)) {
            this.equippedWeapon = new Rock();
        } else {
            this.equippedWeapon = new Claws();
        }    
    }
}