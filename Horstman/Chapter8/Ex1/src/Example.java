import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Created by Acer on 29.03.2017.
 */
public class Example {

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("aaaaaaaaa");
        words.add("bb");
        words.add("ccccc");
        words.add("dddddd");
        words.add("fff");
        words.add("ggggggggggg");
        words.add("hhhh");
        words.add("iiiiiiiiiiiiiiii");
        words.add("jjjjjjjjjjjjj");
        words.add("kkkkk");
        words.add("llllllllllll");
        words.add("mmmmmmmmmmm");
        Stream<String> results = words.stream().filter(s -> {
            System.out.println("filter " + s);
            return  s.length() > 5;
        }).limit(5);
        Iterator<String> it = results.iterator();
        it.forEachRemaining((e) -> {
            System.out.println(e);
        });
    }
}
