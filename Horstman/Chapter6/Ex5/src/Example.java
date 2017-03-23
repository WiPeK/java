import java.util.Arrays;

/**
 * Created by Acer on 22.03.2017.
 */

class Arays {
    public static <T> T[] swap(int i, int j, T... values) {
        T temp = values[i];
        values[i] = values[j];
        values[j] = temp;
        return values;
    }
}

public class Example {



    public static void main(String[] args) {
        Double[] wynik = Arays.<Double>swap(0, 1, 1.5, (double)2, (double)3);
    }
}
