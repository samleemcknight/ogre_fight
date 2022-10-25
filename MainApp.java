import knight.Knight;
import ogre.Ogre;
import weapon.*;
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

    public static Weapon chooseWeapon(Scanner myScanner) {
        String myWeapon = "";
        boolean isValidWeapon = false;
        System.out.println("What is thy chosen weapon? [type 'help' to see weapon choices]");
        while (!isValidWeapon) {
            myWeapon = myScanner.nextLine();
            if (myWeapon.equals("help")) {
                WeaponChoicesHuman.seeWeaponChoicesHuman();
                myWeapon = myScanner.nextLine();
            }
            for (String element: weaponChoicesHuman) {
                if (element.equals(myWeapon)) {
                    isValidWeapon = true;
                }
            }
            if (!isValidWeapon) {
                System.out.println("not valid weapon - please choose again");
            }
        }
        
        return Knight.chooseWeapon(myWeapon);
    }


    public static void main (String[] args) {
        Scanner newScanner = new Scanner(System.in);
        Scanner myScanner = MainApp.newScanner();
        System.out.println("Welcome to Ogre fight! Can you defeat the ogre?");
        String myName = MainApp.setName(myScanner);
        Weapon myWeapon = MainApp.chooseWeapon(myScanner);
        Knight myKnight = new Knight(myWeapon, myName, 20, 1);
        System.out.println("You are a level " + myKnight.level + " knight!");
        myKnight.printWeapons();
        System.out.println("Your weapon of choice is a " + myKnight.equippedWeapon.name);
        newScanner.close();
        Ogre theOgre = new Ogre();
        System.out.println("Your enemey is a level " + theOgre.level + " ogre with " + theOgre.equippedWeapon.name + " and " + theOgre.healthPoints + " HP");
    }
}