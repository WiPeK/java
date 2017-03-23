import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by Acer on 21.03.2017.
 */
public class Example {

    //ex5
    public void  readFile(String filename){
        Scanner in = null;
        PrintWriter out = null;
        try{
            in = new Scanner(Paths.get(filename));
            out = new PrintWriter("./resources/readfile.txt");
            while(in.hasNext())
            {
                out.println(in.next().toLowerCase());
            }
        }
        catch(NumberFormatException | IOException e)
        {
            e.printStackTrace();
        }
        finally {
            in.close();
            out.close();
        }
    }

    public static void main(String[] args) {
        Example ex = new Example();
        String filename = "./resources/test.txt";
        ex.readFile(filename);


    }
}
