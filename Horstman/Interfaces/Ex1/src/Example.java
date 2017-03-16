import java.util.Iterator;
import java.util.Random;
import java.util.function.Consumer;

import static jdk.nashorn.internal.objects.NativeMath.round;

interface Measurable{
    double getMeasure();
    Measurable largest(Measurable[] objects);
}

class Employee implements Measurable{

    private double measure;

    private String name;

    Employee(double measure, String name){
        this.measure = measure;
        this.name = name;
    }

    Employee(){}

    public double getMeasure(){
        return this.measure;
    }

    public String getName(){
        return this.name;
    }

    double average(Measurable[] objects){
        double sum = 0.0;
        int i = 0;
        for(Measurable x: objects){
            sum += x.getMeasure();
            i++;
        }

        return round(sum/i, 2);
    }

    public Measurable largest(Measurable[] objects){
        int i = 0;
        int maxIndex = 0;
        double max = objects[0].getMeasure();
        for(Measurable x: objects){
            if(x.getMeasure() > max){
                maxIndex = i++;
            }
        }
        return objects[maxIndex];
    }
}

class DigitSequence implements Iterator<Integer>{

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        return new Random().nextInt();
    }

    @Override
    public void remove() throws UnsupportedOperationException {

    }

}

public class Example {

    static String getRandomString(){
        final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder tmp = new StringBuilder();
        for(int i = 0; i < new Random().nextInt(20)+2; i++){
            tmp.append(AB.charAt(new Random().nextInt(AB.length())));
        }
        return tmp.toString();
    }

    public static void main(String[] args) {

        Employee[] emp = new Employee[10];
        Random r = new Random();
        for(int i=0; i < 10; i++){
            emp[i] = new Employee(r.nextDouble(), Example.getRandomString());
        }
        System.out.println(emp[1].average(emp));
        Employee em = (Employee)emp[1].largest(emp);
        System.out.println(em.getName());

        DigitSequence ds = new DigitSequence();
        ds.forEachRemaining(e -> System.out.println(e));
        ds.remove();

    }
}
