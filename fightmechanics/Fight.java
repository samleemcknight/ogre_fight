package fightmechanics;
import knight.Knight;
import ogre.Ogre;
import weapon.*;
import asciiimages.*;
import java.util.Scanner;

public class Fight implements WeaponChoicesHuman, WeaponChoicesOgre, Ascii {
    public int round = 0;

    public static Scanner newScanner() {
        Scanner newScanner = new Scanner(System.in);
        return newScanner;
    }

    private boolean isPlayerStillStanding(int healthPoints) {
        if (healthPoints <=0) {
            return false;
        } 
        return true;
    }

    private void makeMove(Knight knight, String decision, Scanner myScanner) {
        if (decision.equals("change weapon")) {
            Weapon newWeapon = Knight.chooseWeaponPrompt(myScanner);
            knight.changeWeapon(newWeapon);
            System.out.println("The knight is now fighting with a " + knight.equippedWeapon.name);
        } else if (decision.equals("run")) {
            System.out.println("This knight is a craven and ran from the ogre!");
            knight.loseGame();
        } 
    }

    public void fightLoop(Knight knight, Ogre ogre) {
        Scanner myScanner = Fight.newScanner();
        while (knight.healthPoints > 0 && ogre.healthPoints > 0) {
            if (this.round > 0) {
                System.out.println("The ogre attacks again!");
            } else {
                System.out.println("The ogre prepares to deal his first blow.");
            }
            int ogreAttackDamage = ogre.attack();
            System.out.println("The ogre attacks with his " + ogre.equippedWeapon.name + " and deals " + ogreAttackDamage + " damage!");
            String move = myScanner.nextLine();
            this.makeMove(knight, move, myScanner);
            knight.dodge(ogreAttackDamage);
            boolean isKnightStillStanding = this.isPlayerStillStanding(knight.healthPoints);
            if (isKnightStillStanding) {
                int knightAttackDamage = knight.attack();
                System.out.println("The knight attacks with his " + knight.equippedWeapon.name + " and deals the foul beast " + knightAttackDamage + " damage!");
                ogre.takeDamage(knightAttackDamage);
                round += 1;
            }
            String endOfRoundMove = myScanner.nextLine();
            this.makeMove(knight, endOfRoundMove, myScanner);
        }
        if (knight.healthPoints > 0) {
            try {
                System.out.println(Ascii.knight());
                knight.winGame();
            } catch (Exception e) {
                knight.winGame();
            }
        } else {
            try {
                System.out.println(Ascii.ogre());
                ogre.winGame();
            } catch (Exception e) {
                ogre.winGame();
            }
        }
    }
}