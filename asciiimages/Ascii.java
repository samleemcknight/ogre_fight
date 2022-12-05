package asciiimages;
import java.io.*;
import java.util.Scanner;;

public interface Ascii {
    public static String ogre() throws FileNotFoundException {
        File file = new File("/Users/sam.mcknight@equipmentshare.com/JavaPractice/OgreFight/asciiimages/troll.txt");
        Scanner myScanner = new Scanner(file);
        myScanner.useDelimiter("\\Z");
        String ogreAscii = myScanner.next();
        myScanner.close();
        return ogreAscii;
    }

    public static String knight() throws FileNotFoundException {
        File file = new File("/Users/sam.mcknight@equipmentshare.com/JavaPractice/OgreFight/asciiimages/knight.txt");
        Scanner myScanner = new Scanner(file);
        myScanner.useDelimiter("\\Z");
        String knightAscii = myScanner.next();
        myScanner.close();
        return knightAscii;
    }
}