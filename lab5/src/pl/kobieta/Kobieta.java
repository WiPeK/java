package pl.kobieta;

import dziecko.Dziecko;
import pl.czlowiek.Czlowiek;
import pl.mezczyzna.Mezczyzna;

import java.util.Random;

/**
 * Created by Acer on 24.04.2017.
 */
public class Kobieta extends Czlowiek {

    Mezczyzna mezczyzna;

    public Dziecko poczecie(Mezczyzna mezczyzna) {
        this.mezczyzna = mezczyzna;
        String plec = new Random().nextBoolean() ? "MEZCZYZNA" : "KOBIETA";
        return new Dziecko(0, 50, 3, plec);
    }

    public Kobieta(int wiek, double wzrost, double waga, String plec) {
        super(wiek, wzrost, waga, plec);
    }

    @Override
    public String toString() {
        return "Kobieta{} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kobieta)) return false;
        if (!super.equals(o)) return false;

        Kobieta kobieta = (Kobieta) o;

        return mezczyzna != null ? mezczyzna.equals(kobieta.mezczyzna) : kobieta.mezczyzna == null;
    }

}
