// KeepLowestScored.java
import java.util.Arrays;

public class KeepLowestScored {
    private String[] values;
    private double[] scores;

    public KeepLowestScored(int howMany) {
        values = new String[howMany + 1];
        scores = new double[howMany + 1];

        for(int i = 0; i < howMany + 1; ++i) {
            scores[i] = Double.MAX_VALUE;
        }
    }

    public void insert(String s, double score) {
        values[values.length - 1] = s;
        scores[scores.length - 1] = score;
        bubbleMinUp(values, scores);
    }

    private static void bubbleMinUp(String[] s, double[] d) {
        for(int i = s.length - 1; i > 0; --i)
            if(d[i] < d[i - 1]) {
                // swap
                double t = d[i];
                d[i] = d[i - 1];
                d[i - 1] = t;

                String ts = s[i];
                s[i] = s[i - 1];
                s[i - 1] = ts;
            }
    }

    public String[] lowestScored() {
        return Arrays.copyOf(values, values.length - 1);
    }
}
