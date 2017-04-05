import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by Acer on 26.03.2017.
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

    public TreeMap<String, Integer> getMap(ArrayList<String> words) {
        TreeMap<String, Integer> result = new TreeMap<>();

        for(String word: words) {
            if(!result.containsKey(word)) {
                result.put(word, 1);
            } else {
                result.put(word, result.get(word) + 1);
            }
        }

        return !result.isEmpty() ? result : null;
    }

    public static void main(String[] args) {
        Example ex = new Example();
        String filename = "./resources/test.txt";
        ArrayList<String> words = ex.readFile(filename);
        TreeMap<String, Integer> map = ex.getMap(words);
        map.forEach((String key, Integer value) -> {
            System.out.println(key + " " + value);
        });
    }
}
