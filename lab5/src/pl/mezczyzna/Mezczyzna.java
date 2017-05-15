package pl.mezczyzna;

import pl.czlowiek.Czlowiek;

/**
 * Created by Acer on 24.04.2017.
 */
public class Mezczyzna extends Czlowiek {
    public Mezczyzna(int wiek, double wzrost, double waga, String plec) {
        super(wiek, wzrost, waga, plec);
    }

    @Override
    public String toString() {
        return "Mezczyzna{}" + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
