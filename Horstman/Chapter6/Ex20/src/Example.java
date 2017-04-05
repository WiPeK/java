import java.util.ArrayList;

/**
 * Created by Acer on 23.03.2017.
 */
public class Example {

    @SafeVarargs public static final <T> T[] repeat(int n, T... objs) {
        ArrayList<T> array = new ArrayList<>();
        for(T x: objs) {
            for(int i = 0; i < n; i++) {
                array.add(x);
            }
        }
        return array.toArray();
    }

    public static void main(String[] args) {
        Integer[] array = Example.repeat(4, 5,7,88,9,22);
        for(Integer x: array) {
            System.out.println(x);
        }
    }

}
