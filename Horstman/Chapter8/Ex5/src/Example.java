import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Acer on 29.03.2017.
 */
public class Example {

    public static Stream<String> letters(String s) {
        return Stream.of(s).map(e -> e.substring(0,1));
    }

    public static void main(String[] args) {
        Stream<String> strm = letters("Kamehameha");
        Iterator<String> it = strm.iterator();
        it.forEachRemaining((e) -> System.out.println(e));
    }
}
