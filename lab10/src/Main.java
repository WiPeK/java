import java.io.*;
import java.util.Random;

/**
 * Created by Krzysztof Adamczyk on 05.06.2017.
 */
public class Main {

    public static void main(String[] args) {
        if(args[0].equals("odczyt")) {
            readFromFile();
        }
        else if(args[0].equals("zapis")) {
            write();
        }
    }

    private static void readFromFile() {
        FileInputStream fi;
        ObjectInputStream oi;
        try{
            fi = new FileInputStream(new File("test.txt"));
            oi = new ObjectInputStream(fi);

            while(true) {
                try {
                    System.out.println((ParentTestClass)oi.readObject());
                } catch (Exception e) {
                    break;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void write() {
        int N = 10;
        ParentTestClass[] tests = new ParentTestClass[N];
        Random random = new Random();
        for(int i = 0; i < N; i++) {
            if(random.nextBoolean()) {
                tests[i] = new TestClass("aa" + i, "bb" + i, "cc" + i);
            } else {
                tests[i] = new TestingClass("dd" + i, "ee" + i, "ff" + i);
            }
        }
        writeToFile(tests);

    }

    private static void writeToFile(ParentTestClass[] tests) {
        FileOutputStream fout = null;
        ObjectOutputStream oos = null;

        try {

            fout = new FileOutputStream("test.txt");
            oos = new ObjectOutputStream(fout);
            for (ParentTestClass test : tests) {
                oos.writeObject(test);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
