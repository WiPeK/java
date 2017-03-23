import java.util.ArrayList;
import java.util.function.Function;

/**
 * Created by Acer on 23.03.2017.
 */
public class Example {

    static <T, R> ArrayList<T> map(ArrayList<T> source, Function<ArrayList<T>, ArrayList<T>> func) {
        ArrayList<T> result = func.apply(source);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> source = new ArrayList<>(2);
        source.add(10);
        source.add(20);
        ArrayList<Integer> result;
        Function<ArrayList<Integer>,ArrayList<Integer>> func = (a) -> {
            ArrayList<Integer> res = new ArrayList<>(1);
            res.add(a.get(0) + a.get(1));
            return res;
        };
        result = Example.map(source, func);
        System.out.println(result.get(0));
    }
}
