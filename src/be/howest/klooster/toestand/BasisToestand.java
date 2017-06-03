package be.howest.klooster.toestand;

import be.howest.klooster.core.Pater;
import be.howest.klooster.core.Woord;
import be.howest.util.Tools;

/**
 *
 * @author Hayk
 */
public final class BasisToestand extends AbstracteToestand {

    public BasisToestand(Pater pater) {
        super(pater);
        pater.setInfo(Tools.toZinMetCommas(pater.getVolledigeNaam(),
                pater.getPersoonlijkheid().toString(),
                getInfoOverAantalGedachten()));
    }

    @Override
    public void bid() {
        super.bid();
        pater.setToestand(pater.getNormaleToestand());
    }

    @Override
    public Woord spreek() {
        pater.setInfo(Tools.toZin(pater.getNaam(), " heeft geen gedachten.",
                "Eerst moet hij bidden of luisteren naar een woord."))
                .triggerChange();
        return null;
    }

    @Override
    public void luister(Woord woord) {
        super.luister(woord);
        pater.setToestand(pater.getNormaleToestand());
    }
}