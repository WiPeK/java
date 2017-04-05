import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Acer on 29.03.2017.
 */
public class Example {

    public static void main(String[] args) {
        int[] values = {1, 4, 9, 16};
        IntStream streamValues = IntStream.of(values);
        Iterator<Integer> it = streamValues.iterator();
        it.forEachRemaining((e) -> {
            System.out.println(e);
        });
    }
}
