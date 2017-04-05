import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

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
        Example ex = new Example();
        String filename = "./resources/wojna.txt";
        ArrayList<String> words = ex.readFile(filename);
        long startStream = System.currentTimeMillis();
        long counterStreamWords = words.stream().filter(s -> s.length() > 12).count();
        long stopStream = System.currentTimeMillis();

        long startParallelStream = System.currentTimeMillis();
        long counterParallelStreamWords = words.parallelStream().filter(s -> s.length() > 12).count();
        long stopParallelStream = System.currentTimeMillis();

        System.out.println("Stream - words: " + counterStreamWords + " time: " + (stopStream - startStream));
        System.out.println("Parallel Stream - words: " + counterParallelStreamWords + " time: " + (stopParallelStream - startParallelStream));
    }
}
