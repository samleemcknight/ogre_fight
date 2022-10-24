import knight.Knight;
import weapon.WeaponChoices;
import java.util.Scanner;

public class MainApp implements WeaponChoices {

    public static Scanner newScanner() {
        Scanner newScanner = new Scanner(System.in);
        return newScanner;
    }

    public static String setName(Scanner myScanner) {
        System.out.println("What is thy name?");
        String myName = myScanner.nextLine();
        return myName;
    }

    public static String chooseWeapon(Scanner myScanner) {
        String myWeapon = "";
        boolean isValidWeapon = false;
        System.out.println("What is thy chosen weapon? ['help' to see weapon choices]");
        while (!isValidWeapon) {
            myWeapon = myScanner.nextLine();
            if (myWeapon.equals("help")) {
                WeaponChoices.seeWeaponChoices();
                myWeapon = myScanner.nextLine();
            }
            for (String element: weaponChoices) {
                if (element.equals(myWeapon)) {
                    isValidWeapon = true;
                }
            }
            if (!isValidWeapon) {
                System.out.println("not valid weapon - please choose again");
            }
        }
        return myWeapon;
    }


    public static void main (String[] args) {
        Scanner newScanner = new Scanner(System.in);
        System.out.println("Welcome to Knight fight! Can you defeat the ogre?");
        Scanner myScanner = MainApp.newScanner();
        String myName = MainApp.setName(myScanner);
        String myWeapon = MainApp.chooseWeapon(myScanner);
        Knight myKnight = new Knight(myWeapon, myName, 20, 1);
        System.out.println("You are a level " + myKnight.level + " knight!");
        System.out.println("Your weapon of choice is a " + myKnight.equippedWeapon.name);
        newScanner.close();
    }
}