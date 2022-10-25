package weapon;
import java.util.Arrays;

public interface WeaponChoicesHuman {
    public String axe = "axe";
    public String sword = "sword";
    public String hands = "hands";
    public String[] weaponChoicesHuman = new String[]{axe, sword, hands};
    
    public static void seeWeaponChoicesHuman() {
        System.out.println(Arrays.toString(weaponChoicesHuman));
    }

}