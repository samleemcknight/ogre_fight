package weapon;
import java.util.Arrays;

public interface WeaponChoices {
    public String axe = "axe";
    public String sword = "sword";
    public String[] weaponChoices = new String[]{axe, sword};
    
    public static void seeWeaponChoices() {
        System.out.println(Arrays.toString(weaponChoices));
    }

}