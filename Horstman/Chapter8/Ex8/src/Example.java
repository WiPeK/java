import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    public Stream<String> getMatched(ArrayList<String> words) {
        return words.stream().filter((e) -> e.contains("a") && e.contains("e") && e.contains("i") && e.contains("o") && e.contains("u"));
    }

    public double getAverageWordLength(ArrayList<String> words) {
        return words.stream().map(s -> s.length()).mapToDouble(Double::new).average().getAsDouble();
    }

    public Stream<String> getLongestWords(ArrayList<String> words) {
        return words.stream().map(s -> s.length()).;
    }

    public static void main(String[] args) {
        Example ex = new Example();
        String filename = "./resources/test.txt";
        ArrayList<String> words = ex.readFile(filename);
        Stream<String> sstr = ex.getMatched(words);
        Iterator<String> it = sstr.iterator();
        it.forEachRemaining(e -> System.out.println(e));

        Example ex9 = new Example();
        String filename9 = "./resources/test9.txt";
        ArrayList<String> words9 = ex9.readFile(filename9);
        System.out.println(ex9.getAverageWordLength(words9));


    }
}
