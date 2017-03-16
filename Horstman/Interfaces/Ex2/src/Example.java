import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Acer on 15.03.2017.
 */

//class Test{
//
//    void lickySort(ArrayList<String> strings, Comparator<String> comp){
//        Collections.shuffle(strings, comp.compare());
//    }
//}

class Greeter implements Runnable{

    private int n;
    private String target;

    Greeter(int n, String target){
        this.n = n;
        this.target = target;
    }

    @Override
    public void run(){
        try{
            for(int i = 0; i < this.n; i++){
                System.out.println("Hello " + this.target);
                Thread.sleep(1);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void runTogether(Runnable... tasks){
        for(Runnable x: tasks)
            new Thread(x).start();
    }

    public static void runInOrder(Runnable... tasks){
        for(Runnable x: tasks)
            x.run();
    }
}

public class Example {

    public static void main(String[] args) {
//        ArrayList<String> tmp = new ArrayList<String>();
//        Random r = new Random();
//
//        for(int i = 0; i < 20; i++){
//            char c = (char)(r.nextInt(26) + 'a');
//            tmp.add(Character.toString(c));
//        }
//
//        Test t = new Test();
//        t.lickySort(tmp, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });
//
//        for(String x: tmp)
//            System.out.println(x);

        new Thread(new Greeter(100, "Janusz")).start();
        new Thread(new Greeter(100, "Heniek")).start();

        Greeter.runInOrder(new Greeter(5, "Andrzej"), new Greeter(7, "Zygfryd"), new Greeter(4, "Norbert"));
        Greeter.runTogether(new Greeter(5, "Grzes"), new Greeter(7, "Pawel"), new Greeter(4, "Kuba"));
    }
}
