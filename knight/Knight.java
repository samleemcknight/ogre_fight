package knight;
import fighter.Fighter;
import java.util.Arrays;
import weapon.*;

public class Knight extends Fighter implements WeaponChoicesHuman {
    public Weapon[] weapons;
    public String name;

    public Knight(Weapon weapon, String name, int healthPoints, int level) {
        super(weapon, healthPoints, level);
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

    public int attack() {
        int maxDamage = this.equippedWeapon.maxDamage;
        int minDamage = this.equippedWeapon.minDamage;
        int attackDamage = (int)Math.floor(Math.random()*(maxDamage-minDamage)+minDamage);
        return attackDamage;
    }

    public void takeDamage(int damage) {
        int currentHP = this.healthPoints;
        int newHP = currentHP - damage;
        this.healthPoints = newHP;
    }

    public void printWeapons() {
        System.out.println(Arrays.toString(this.weapons));
    }

    public static void main (String[] args) {
        System.out.println("In main");
    }
}