package be.howest.klooster.core;

/**
 *
 * @author Hayk
 */
public class Inspiratie {
    
    public static final int MIN = 1;
    public static final int MAX = 9;

    private static Inspiratie uniqueInstance;

    private int concept = MIN;

    private Inspiratie() {
    }

    public static synchronized Inspiratie getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Inspiratie();
        }
        return uniqueInstance;
    }

    public int inspireerMij() {
        int result = concept++;
        if (concept > MAX) {
            concept = MIN;
        }
        return result;
    }
}
