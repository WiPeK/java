import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Acer on 28.03.2017.
 */
public class Example {

    public static List<Integer> getView() {
        return Collections.unmodifiableList(IntStream.range(1,10).collect(ArrayList::new, List::add, List::addAll));
    }

    public static void main(String[] args) {
        List<Integer> tmp = Example.getView();
        for(Integer x: tmp) {
            System.out.println(x);
        }
    }
}
