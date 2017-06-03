package be.howest.klooster.core;

import be.howest.util.Tools;
import java.util.Random;

/**
 *
 * @author Hayk
 */
public class Persoonlijkheid {

    private static final int MIN_GOEDHEID = 0;
    private static final int MAX_GOEDHEID = 99;
    private static final int MAX_GOEDHEID_EVIL = MAX_GOEDHEID / 3;
    private static final int MAX_GOEDHEID_NEUTRAL = 2 * (MAX_GOEDHEID / 3);

    private static final int MIN_CREATIVITEIT = 0;
    private static final int MAX_CREATIVITEIT = 99;
    private static final int MAX_CREATIVITEIT_LAWFUL = MAX_CREATIVITEIT / 3;
    private static final int MAX_CREATIVITEIT_NEUTRAAL = 2 * (MAX_CREATIVITEIT / 3);

    private int goedheid = MIN_GOEDHEID;
    private int creativiteit = MIN_CREATIVITEIT;

    static Persoonlijkheid createRandomPersoonlijkheid() {
        Random random = new Random();
        Persoonlijkheid instance = new Persoonlijkheid();
        instance.goedheid = Tools.getRandomInt(MIN_GOEDHEID, MAX_GOEDHEID, random);
        instance.creativiteit = Tools.getRandomInt(MIN_CREATIVITEIT,
                MAX_CREATIVITEIT, random);
        return instance;
    }
    
    int getGoedheid() {
        return goedheid;
    }

    void setGoedheid(int goedheid) {
        if (goedheid < MIN_GOEDHEID) {
            this.goedheid = MIN_GOEDHEID;
        } else if (goedheid > MAX_GOEDHEID) {
            this.goedheid = MAX_GOEDHEID;
        } else {
            this.goedheid = goedheid;
        }
    }

    int getCreativiteit() {
        return creativiteit;
    }

    void setCreativiteit(int creativiteit) {
        if (creativiteit < MIN_CREATIVITEIT) {
            this.creativiteit = MIN_CREATIVITEIT;
        } else if (creativiteit > MIN_CREATIVITEIT) {
            this.creativiteit = MIN_CREATIVITEIT;
        } else {
            this.creativiteit = creativiteit;
        }
    }

    private String goedheidToString() {
        if (goedheid == MIN_GOEDHEID) {
            return "puur kwaad";
        }
        if (goedheid > MIN_GOEDHEID && goedheid <= MAX_GOEDHEID_EVIL) {
            return "kwaad";
        }
        if (goedheid > MAX_GOEDHEID_EVIL && goedheid <= MAX_GOEDHEID_NEUTRAL) {
            return "neutraal";
        }
        if (goedheid > MAX_GOEDHEID_NEUTRAL && goedheid < MAX_GOEDHEID) {
            return "goed";
        }
        if (goedheid == MAX_GOEDHEID) {
            return "absoluut goed";
        }
        return "";
    }
    
    private String creativiteitToString() {
        if (creativiteit >= MIN_CREATIVITEIT && creativiteit <= MAX_CREATIVITEIT_LAWFUL) {
            return "rechtmatig";
        }
        if (creativiteit > MAX_CREATIVITEIT_LAWFUL && creativiteit <= MAX_CREATIVITEIT_NEUTRAAL) {
            return "neutraal";
        }
        if (creativiteit > MAX_CREATIVITEIT_NEUTRAAL && creativiteit <= MAX_CREATIVITEIT) {
            return "chaotisch";
        }
        return "";
    }

    @Override
    public String toString() {
        return Tools.toZin(goedheidToString(), creativiteitToString());
    }
}