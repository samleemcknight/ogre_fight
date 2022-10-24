import knight.Knight;
import weapon.WeaponChoices;
import java.util.Scanner;

public class MainApp implements WeaponChoices {

    public static void main (String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Welcome to Knight fight! Can you defeat the ogre?");
        System.out.println("What is thy name?");
        String myName = myScanner.nextLine();
        System.out.println("What is thy chosen weapon?");
        WeaponChoices.seeWeaponChoices();
        String myWeapon = myScanner.nextLine();
        Knight myKnight = new Knight(myWeapon, myName, 20, 1);
        myScanner.close();
        System.out.println("You are a level " + myKnight.level + " knight!");
        System.out.println("Your weapon of choice is a " + myKnight.equippedWeapon.name);
    }
}