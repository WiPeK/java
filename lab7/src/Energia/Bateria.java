package Energia;

/**
 * Created by Krszysztof Adamczyk on 15.05.2017.
 */
public class Bateria implements EnergiaElektryczna {
    @Override
    public void ladunek() {
        System.out.println("Laduje baterie");
    }
}
