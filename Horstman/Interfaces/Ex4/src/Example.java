import java.util.Random;

/**
 * Created by Acer on 16.03.2017.
 */

class Task implements Runnable{
    @Override
    public void run(){
        System.out.println(new Random().nextInt(1000));
    }
}

public class Example {

    static Runnable test(Task[] tasks){
        return new Runnable() {
            @Override
            public void run() {
                for(Runnable x: tasks)
                    x.run();
            }
        };
    }

    public static void main(String[] args) {

        Task[] tmp = new Task[10];
        for(int i = 0; i < 10; i++){
            tmp[i] = new Task();
        }

        test(tmp).run();

    }
}
