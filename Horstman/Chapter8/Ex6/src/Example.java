import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Acer on 29.03.2017.
 */
public class Example {

    public static void main(String[] args) {
        String test = "dsfhksdhfjdsbfhjk5gsdkjf";
        IntStream testStream = test.codePoints();
        Boolean t = testStream.allMatch(e -> Character.isAlphabetic(e));
        System.out.println(t ? "OK" : "FALSE");
        String[] keywords = {"abstract", "default", "goto"};
        String key = "gotoz";
        Boolean k = Stream.of(keywords).anyMatch(s -> {
            return s.equals(key);
        });
        System.out.println(k ? "OK" : "FALSE");

    }
}
