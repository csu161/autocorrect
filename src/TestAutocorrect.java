// TestAutocorrect.java
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class TestAutocorrect {
    public static void main(String[] args) throws FileNotFoundException {
        IAutocorrect correcter = new MinMaxDistCorrecter(args[0], args[1]);

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String[] corrections = correcter.possibleCorrections(sc.next(), 20);
            System.out.println(Arrays.toString(corrections));
        }
    }
}
