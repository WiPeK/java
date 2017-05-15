package dziecko;

import pl.czlowiek.Czlowiek;

/**
 * Created by Acer on 24.04.2017.
 */
public class Dziecko extends Czlowiek{

    public Dziecko(int wiek, double wzrost, double waga, String plec) {
        super(wiek, wzrost, waga, plec);
    }

    public Dziecko() {
    }

    @Override
    public String toString() {
        return "Dziecko{}" + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
