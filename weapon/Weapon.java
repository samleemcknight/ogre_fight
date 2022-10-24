package weapon;

public class Weapon {
    public String name;
    public int minDamage;
    public int maxDamage;
    
    public Weapon(String name, int minDamage, int maxDamage) {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }
}