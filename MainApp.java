import knight.Knight;
import ogre.Ogre;
import weapon.*;
import fightmechanics.Fight;
import java.util.Scanner;

public class MainApp implements WeaponChoicesHuman {

    public static Scanner newScanner() {
        Scanner newScanner = new Scanner(System.in);
        return newScanner;
    }

    public static String setName(Scanner myScanner) {
        System.out.println("What is thy name?");
        String myName = myScanner.nextLine();
        return myName;
    }


    public static void main (String[] args) {
        Scanner myScanner = MainApp.newScanner();
        System.out.println("Welcome to Ogre fight! Can you defeat the ogre?");
        String myName = MainApp.setName(myScanner);
        Weapon myWeapon = Knight.chooseWeaponPrompt(myScanner);
        Knight myKnight = new Knight(myWeapon, myName, 20, 1);
        System.out.println("You are a level " + myKnight.level + " knight!");
        System.out.println("Your weapon of choice is a " + myKnight.equippedWeapon.name);
        Ogre theOgre = new Ogre();
        System.out.println("Your enemey is a level " + theOgre.level + " ogre with " + theOgre.equippedWeapon.name + " and " + theOgre.healthPoints + " HP");
        System.out.println("Begin fighting!");
        Fight newFight = new Fight();
        newFight.fightLoop(myKnight, theOgre);
    }
}