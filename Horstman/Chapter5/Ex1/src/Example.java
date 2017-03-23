import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Acer on 21.03.2017.
 */
public class Example {

    //ex1
    public void generateFile(String filename) throws FileNotFoundException{
        PrintStream out = new PrintStream(new FileOutputStream(filename));
        Random generator = new Random();
        for(int i = 0; i < 10000; i++)
        {
            out.println((generator.nextDouble()%1000)*1000);
        }
        out.close();
    }

    //ex1
    public ArrayList<Double> readValues(String filename) throws FileNotFoundException, NumberFormatException{
        ArrayList<Double> list = new ArrayList<>();
        Scanner sc = new Scanner(new File(filename));
        while(sc.hasNext())
        {
            list.add(Double.parseDouble(sc.next()));
        }
        sc.close();
        return list;
    }

    //ex2
    public double sumOfValues(String filename) throws FileNotFoundException{
        ArrayList<Double> list = this.readValues(filename);
        double sum = 0.0;
        for(double x: list){
            sum += x;
        }
        return sum;
    }

    public static void main(String[] args) {
        //ex3
        Example ex = new Example();
        String filename = "./resources/test.txt";
        try{
            ex.generateFile(filename);
            ArrayList<Double> list = ex.readValues(filename);
            for(Double x: list){
                System.out.println(x);
            }
            //ex2
            System.out.println("Sum of values in file: " + ex.sumOfValues(filename));
        }
        catch(FileNotFoundException | NumberFormatException e)
        {
            e.printStackTrace();
        }

    }
}
