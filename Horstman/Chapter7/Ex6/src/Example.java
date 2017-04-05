import java.util.*;

/**
 * Created by Acer on 26.03.2017.
 */

public class Example {

    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        Set<Integer> c = new HashSet<>();
        for(int i = 0; i < 10; i++) {
            a.add(i);
            b.add(i+5);
            c.add(i+10);
        }
        Map<String, Set<Integer>> ma = new TreeMap<>();
        ma.put("a", a);
        ma.put("b", b);
        ma.put("c", c);
        ma.forEach((String k, Set<Integer> v) -> {
            System.out.println(k);
            System.out.println(Arrays.toString(v.toArray()));
        });
    }
}
