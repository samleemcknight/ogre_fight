package weapon;
import java.util.Arrays;

public interface WeaponChoicesOgre {
    public String claws = "claws";
    public String rock = "rock";
    public String club = "club";
    public String[] weaponChoicesOgre = new String[]{claws, rock, club};
    
    public static void seeweaponChoicesOgre() {
        System.out.println(Arrays.toString(weaponChoicesOgre));
    }

}