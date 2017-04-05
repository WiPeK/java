import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Acer on 28.03.2017.
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
        Example ex = new Example();
        String filename = "./resources/test.txt";
        ArrayList<String> words = ex.readFile(filename);
        for(String x: words) {
            System.out.println(x);
        }
        System.out.println("After shuffle");
        Collections.shuffle(words.subList(1, words.size()-1));
        for(String x: words) {
            System.out.println(x);
        }
    }
}
