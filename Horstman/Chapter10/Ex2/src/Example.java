import java.util.Arrays;
import java.util.Random;

/**
 * Created by Acer on 06.04.2017.
 */
public class Example {

    public static void main(String[] args) {
        Random r = new Random();
        int numberOfElements = 100000000;
        int[] tab = new int[numberOfElements];
        int[] tabPar = new int[numberOfElements];
        for(int i = 0; i < numberOfElements; i++) {
            int a = r.nextInt();
            tabPar[i] = tab[i] = a;
        }
        long startSort = System.currentTimeMillis();
        Arrays.sort(tab);
        long stopSort = System.currentTimeMillis();

        long startPar = System.currentTimeMillis();
        Arrays.parallelSort(tabPar);
        long stopPar = System.currentTimeMillis();

        System.out.println("Normal: " + (stopSort - startSort));
        System.out.println("Multi: " + (stopPar - startPar));
    }
}
