import Energia.Akumulator;
import Energia.Bateria;
import Energia.Dynamo;
import Energia.EnergiaElektryczna;
import Postac.Lucznik;
import Postac.Mag;
import Postac.PostacGrywalna;
import Postac.Rycerz;

/**
 * Created by Krszysztof Adamczyk on 15.05.2017.
 */
public class Main {

    public static void main(String[] args) {
        PostacGrywalna lucznik = new Lucznik();
        lucznik.atak();
        PostacGrywalna mag = new Mag();
        mag.atak();
        PostacGrywalna rycerz = new Rycerz();
        rycerz.atak();

        EnergiaElektryczna akumulator = new Akumulator();
        akumulator.ladunek();
        EnergiaElektryczna dynamo = new Dynamo();
        dynamo.ladunek();
        EnergiaElektryczna bateria = new Bateria();
        bateria.ladunek();
    }
}
