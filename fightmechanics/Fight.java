package fightmechanics;
import knight.Knight;
import ogre.Ogre;
import weapon.*;

public class Fight implements WeaponChoicesHuman, WeaponChoicesOgre {
    public int round = 0;

    private boolean isPlayerStillStanding(int healthPoints) {
        if (healthPoints <=0) {
            return false;
        } 
        return true;
    }

    public void fightLoop(Knight knight, Ogre ogre) {
        while (knight.healthPoints > 0 && ogre.healthPoints > 0) {
            if (this.round > 0) {
                System.out.println("The ogre attacks again!");
            } else {
                System.out.println("The ogre prepares to deal his first blow.");
            }
            int ogreAttackDamage = ogre.attack();
            System.out.println("The ogre attacks with his " + ogre.equippedWeapon.name + " and deals " + ogreAttackDamage + " damage!");
            knight.dodge(ogreAttackDamage);
            boolean isKnightStillStanding = this.isPlayerStillStanding(knight.healthPoints);
            if (isKnightStillStanding) {
                int knightAttackDamage = knight.attack();
                System.out.println("The knight attacks with his " + knight.equippedWeapon.name + " and deals the foul beast " + knightAttackDamage + " damage!");
                ogre.takeDamage(knightAttackDamage);
                round += 1;
            }
        }
    }
}