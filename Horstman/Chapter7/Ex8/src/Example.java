import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by Acer on 26.03.2017.
 */
public class Example {

//    public TreeMap<String, Set<Integer>> readFile(String filename){
//        Scanner in = null;
//        TreeMap<String, Set<Integer>> result = new TreeMap<>();
//        try{
//            in = new Scanner(Paths.get(filename));
//            int linesCounter = 1;
//            while(in.hasNext())
//            {
//                String word = in.next();
//                if(!result.containsKey(word)) {
//                    Set<Integer> tmp = new TreeSet<>();
//                    tmp.add(linesCounter);
//                    result.put(word, tmp);
//                } else {
//                    Set<Integer> tmp = result.get(word);
//                    tmp.add(linesCounter);
//                    result.put(word, tmp);
//                }
//
//                linesCounter++;
//            }
//        }
//        catch(NumberFormatException | IOException e)
//        {
//            e.printStackTrace();
//        }
//        finally {
//            in.close();
//        }
//        return result;
//    }

    public TreeMap<String, Set<Integer>> readFile(String filename){
        Scanner in = null;
        TreeMap<String, Set<Integer>> result = new TreeMap<>();
        try{
            in = new Scanner(Paths.get(filename));
            int linesCounter = 1;
            while(in.hasNext())
            {
                String word = in.next();

                if(!result.containsKey(word)) {
                    Set<Integer> tmp = new TreeSet<>();
                    tmp.add(linesCounter);
                    result.put(word, tmp);
                } else {
                    Set<Integer> tmp = result.get(word);
                    tmp.add(linesCounter);
                    result.put(word, tmp);
                }

                linesCounter++;
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
        TreeMap<String, Set<Integer>> map = ex.readFile(filename);
        map.forEach((String key, Set<Integer> value) -> {
            System.out.println(key + " " + value.toString());
        });
    }
}
