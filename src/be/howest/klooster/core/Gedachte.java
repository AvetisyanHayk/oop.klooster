package be.howest.klooster.core;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 *
 * @author Hayk
 */
public class Gedachte {

    private final int concept;
    private final Persoonlijkheid mening;

    public Gedachte(int concept, Persoonlijkheid mening) {
        if (mening == null || !Inspiratie.isValidConcept(concept)) {
            throw new IllegalArgumentException();
        }
        this.concept = concept;
        this.mening = mening;
    }

    public int getConcept() {
        return concept;
    }

    public int getGoedheid() {
        return mening.getGoedheid();
    }

    public int getCreativiteit() {
        return mening.getCreativiteit();
    }

    public Persoonlijkheid getMening() {
        return mening;
    }

    public Woord verwoord(Persoonlijkheid begeestering) {
        if (begeestering == null) {
            throw new IllegalArgumentException();
        }
        return new Woord(this, begeestering);
    }

    public static Set<Persoonlijkheid> mapMeningenUitGedachten(Set<Gedachte> gedachten) {
        return gedachten.stream().map(Gedachte::getMening).collect(
                Collectors.toCollection(() ->
                        new TreeSet<>(new PersoonlijkheidComparator())));
    }

    @Override
    public String toString() {
        return String.format(Berichten.GEDACHTE, mening, concept);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.concept;
        hash = 97 * hash + Objects.hashCode(this.mening);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Gedachte other = (Gedachte) obj;
        if (this.concept != other.concept) {
            return false;
        }
        return Objects.equals(this.mening, other.mening);
    }

}
