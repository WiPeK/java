package pl.czlowiek;

/**
 * Created by Acer on 24.04.2017.
 */
public abstract class Czlowiek {

    private int wiek;

    private double wzrost;

    private double waga;

    private String plec;

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public double getWzrost() {
        return wzrost;
    }

    public void setWzrost(double wzrost) {
        this.wzrost = wzrost;
    }

    public double getWaga() {
        return waga;
    }

    public void setWaga(double waga) {
        this.waga = waga;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public Czlowiek(int wiek, double wzrost, double waga, String plec) {
        this.wiek = wiek;
        this.wzrost = wzrost;
        this.waga = waga;
        this.plec = plec;
    }

    public Czlowiek() {
    }

    @Override
    public String toString() {
        return "Czlowiek{" +
                "wiek=" + wiek +
                ", wzrost=" + wzrost +
                ", waga=" + waga +
                ", plec='" + plec + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Czlowiek)) return false;

        Czlowiek czlowiek = (Czlowiek) o;

        if (wiek != czlowiek.wiek) return false;
        if (Double.compare(czlowiek.wzrost, wzrost) != 0) return false;
        if (Double.compare(czlowiek.waga, waga) != 0) return false;
        return plec != null ? plec.equals(czlowiek.plec) : czlowiek.plec == null;
    }

}
