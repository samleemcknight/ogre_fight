package knight;
import java.util.Arrays;
import weapon.*;

public class Knight implements WeaponChoices {
    public Weapon[] weapons;
    public Weapon equippedWeapon;
    public String name;
    public int healthPoints;
    public int level;

    public Knight(String weapon, String name, int healthPoints, int level) {
        this.equippedWeapon = this.chooseWeapon(weapon);
        this.name = name;
        this.healthPoints = healthPoints;
        this.level = level;
        this.weapons = Knight.addElement(this.weapons, this.equippedWeapon);
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

    public Weapon chooseWeapon(String weapon) {
        if (weapon.equals(WeaponChoices.sword)) {
            this.equippedWeapon = new Sword();
        } else if (weapon.equals(WeaponChoices.axe)) {
            this.equippedWeapon = new Axe();
        }
        return this.equippedWeapon;
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