// KeyMap.java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class KeyMap {
    private static class KeyCoordinate {
        public final int x, y;

        public KeyCoordinate(int _x, int _y) {
            x = _x;
            y = _y;
        }

        public double distanceTo(KeyCoordinate other) {
            return Math.hypot(x - other.x, y - other.y);
        }
    }

    private Map<Character, KeyCoordinate> letterToCoord;

    public KeyMap() {
        letterToCoord = new TreeMap<Character, KeyCoordinate>();
    }

    public void associateCoordinates(char c, int x, int y) {
        letterToCoord.put(c, new KeyCoordinate(x, y));
    }

    public double getDistanceBetween(char a, char b) {
        KeyCoordinate ka = letterToCoord.get(a);
        KeyCoordinate kb = letterToCoord.get(b);
        if(ka == null)
            throw new IllegalArgumentException(String.format("Could not find character '%c' in KeyMap", a));
        if(kb == null)
            throw new IllegalArgumentException(String.format("Could not find character '%c' in KeyMap", b));
        return letterToCoord.get(a).distanceTo(letterToCoord.get(b));
    }
}
