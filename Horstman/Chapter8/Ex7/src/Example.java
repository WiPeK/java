import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Acer on 29.03.2017.
 */
public class Example {

    public ArrayList<String> readFile(String filename){
        Scanner in = null;
        ArrayList<String> result = new ArrayList<>();
        try{
            in = new Scanner(Paths.get(filename));
            while(in.hasNext())
            {
                result.add(in.next());
            }
        }
        catch(NumberFormatException | IOException e)
        {
            e.printStackTrace();
        }
        finally {
            in.close();
        }
        return result;
    }

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

        Example ex = new Example();
        String filename = "./resources/test.txt";
        ArrayList<String> words = ex.readFile(filename);
    }
}
