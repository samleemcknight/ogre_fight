package knight;
import fighter.Fighter;
import java.util.Arrays;
import java.util.Scanner;
import weapon.*;

public class Knight extends Fighter implements WeaponChoicesHuman {
    public Weapon[] weapons;
    public String name;

    public Knight(Weapon weapon, String name, int healthPoints, int level) {
        super(weapon, healthPoints, level, "knight");
        this.name = name;
        this.weapons = new Weapon[]{weapon};
    }

    public static Weapon[] addElement(Weapon[] arr, Weapon element) {
        if (arr == null) {
            Weapon newArr[] = {element};
            return newArr;
        }
        Weapon newArr[] = new Weapon[arr.length + 1];
        newArr[0] = element;
        for (int i = 0; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }
        return newArr;
    }

    public static Weapon chooseWeaponPrompt(Scanner myScanner) {
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

    public void changeWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
        this.weapons = Knight.addElement(this.weapons, this.equippedWeapon);
    }

    public static Weapon chooseWeapon(String weaponName) {
        Weapon equippedWeapon;
        if (weaponName.equals(WeaponChoicesHuman.sword)) {
            equippedWeapon = new Sword();
        } else if (weaponName.equals(WeaponChoicesHuman.axe)) {
            equippedWeapon = new Axe();
        } else {
            equippedWeapon = new Hands();
        }
        return equippedWeapon;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void dodge(int attackDamage) {
        int dexterity = 13;
        int dodgeProbability = (int)Math.floor(Math.random()*(dexterity-0)+1);
        if (dodgeProbability < 10) {
         this.takeDamage(attackDamage);   
        } else {
            System.out.println("The knight has dodged the blow!");
        }
    }

    public void printWeapons() {
        System.out.println(Arrays.toString(this.weapons));
    }

    public static void main (String[] args) {
        System.out.println("In main");
    }
}