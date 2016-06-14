// MinMaxDistCorrecter.java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


// Our test code assumes you have a class named "MinMaxDistCorrecter" that must implement the IAutocorrect interface
public class MinMaxDistCorrecter implements IAutocorrect {
    private ArrayList<String> words;
    private KeyMap keymap;

    public MinMaxDistCorrecter(String dict_filename, String keyCoordinate_filename)
        throws FileNotFoundException {
        Scanner sc = new Scanner(new File(dict_filename));
        words = wordsFromFile(sc);
        sc.close();

        sc = new Scanner(new File(keyCoordinate_filename));
        keymap = loadKeyMap(sc);
        sc.close();
    }

    // reads all words from dictionary file
    private static ArrayList<String> wordsFromFile(Scanner sc) {
        ArrayList<String> ret = new ArrayList<String>();
        while(sc.hasNext())
            ret.add(sc.next());
        return ret;
    }

    // creates new KeyMap object and loads it with file contents
    private static KeyMap loadKeyMap(Scanner sc) {
        KeyMap km = new KeyMap();
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            Scanner line_sc = new Scanner(line);

            char c = line_sc.next().charAt(0);
            int x = line_sc.nextInt();
            int y = line_sc.nextInt();

            km.associateCoordinates(c, x, y);
        }
        return km;
    }

    // returns possible corrections (return array should have length numberCorrections)
    public String[] possibleCorrections(String wordToCorrect, int numberCorrections) {
        KeepLowestScored lowest = new KeepLowestScored(numberCorrections);
        for(int i = 0; i < words.size(); ++i)
            if(wordToCorrect.length() == words.get(i).length()) {
                String cmp = words.get(i);
                double dist = maxLetterDistance(wordToCorrect, cmp);
                lowest.insert(cmp, dist);
            }

        return lowest.lowestScored();
    }

    // assumes a.length() == b.length()
    // computes distance between first character of a and b, then second character...
    // returns the maximum distance found
    private double maxLetterDistance(String a, String b) {
        double max = 0;
        for(int i = 0; i < a.length(); ++i) {
            char ac = Character.toLowerCase(a.charAt(i));
            char bc = Character.toLowerCase(b.charAt(i));

            double diff = keymap.getDistanceBetween(ac, bc);
            if(diff > max)
                max = diff;
        }

        return max;
    }
}
