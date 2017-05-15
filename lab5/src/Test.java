import dziecko.Dziecko;
import pl.kobieta.Kobieta;
import pl.mezczyzna.Mezczyzna;

/**
 * Created by Acer on 24.04.2017.
 */
public class Test {

    public static void main(String[] args) {
        String kob = "KOBIETA";
        String mez = "MEZCZYZNA";
        Kobieta kobieta = new Kobieta(30, 175, 67, kob);
        Mezczyzna mezczyzna = new Mezczyzna(32, 183, 80, mez);
        Dziecko dziecko = kobieta.poczecie(mezczyzna);

        System.out.println(kobieta);
        System.out.println(mezczyzna);
        System.out.println(dziecko);

        Kobieta kobi = new Kobieta(20, 165, 57, kob);
        Mezczyzna mezc = new Mezczyzna(22, 173, 70, mez);
        Dziecko dzieck = kobi.poczecie(mezc);

        System.out.println(kobi);
        System.out.println(mezc);
        System.out.println(dzieck);

        System.out.println(kobieta.equals(kobi));
        System.out.println(mezczyzna.equals(mezc));
        System.out.println(dziecko.equals(dzieck));
    }
}
