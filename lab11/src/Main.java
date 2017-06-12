/**
 * Created by Krzysztof Adamczyk on 12.06.2017.
 */
public class Main {

    public static void main(String[] args) {

        Test test = new Test();

        Runnable task1 = () -> {
            final int VALUE = 1;
            System.out.println("Thread 1 before update: " + test.getValue());
            test.update(VALUE);
            System.out.println("Thread 1 after update: " + test.getValue());
        };

        Runnable task2 = () -> {
            final int VALUE = 2;
            System.out.println("Thread 2 before update: " + test.getValue());
            test.update(VALUE);
            System.out.println("Thread 2 after update: " + test.getValue());
        };

        Runnable task3 = () -> {
            final int VALUE = 3;
            System.out.println("Thread 3 before update: " + test.getValue());
            test.update(VALUE);
            System.out.println("Thread 3 after update: " + test.getValue());
        };

        Runnable task4 = () -> {
            final int VALUE = 4;
            System.out.println("Thread 4 before update: " + test.getValue());
            test.update(VALUE);
            System.out.println("Thread 4 after update: " + test.getValue());
        };

        new Thread(task1).run();
        new Thread(task2).run();
        new Thread(task3).run();
        new Thread(task4).run();

        System.out.println("End value: " + test.getValue());
    }
}
