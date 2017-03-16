import java.util.Random;

/**
 * Created by Acer on 13.03.2017.
 */
public class Lotery {

    public static void main(String[] args) {
        Random r = new Random();
        int idKupon = r.nextInt(10000);
        Kupon kup = new Kupon(idKupon, r.nextInt(10));
        Player pl = new Player("Andrzej", idKupon);
        if(kup.isWiner())
        {
            System.out.println(pl.getName() + " wygrał " + kup.getWonValue() + " zł");
        }
        else
            System.out.println(pl.getName() + " NIC NIE WYGRAŁ!!!");


    }
}
