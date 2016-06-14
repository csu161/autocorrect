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
        // code here
    }

    // reads all words from dictionary file
    private static ArrayList<String> wordsFromFile(Scanner sc) {
        // code here
        return null;
    }

    // creates new KeyMap object and loads it with file contents
    private static KeyMap loadKeyMap(Scanner sc) {
        // code here
        return null;
    }

    // returns possible corrections (return array should have length numberCorrections)
    public String[] possibleCorrections(String wordToCorrect, int numberCorrections) {
        // code here
        return null;
    }

    // assumes a.length() == b.length()
    // computes distance between first character of a and b, then second character...
    // returns the maximum distance found
    private double maxLetterDistance(String a, String b) {
        // code here
        return 0;
    }
}
