import com.sun.deploy.util.ArrayUtil;

import java.time.Instant;
import java.util.Arrays;
import java.util.Random;
import java.util.function.Predicate;

/**
 * Created by Acer on 21.03.2017.
 */
public class Example {

    public int min(int[] values){
        int min = values[0];
        for(int i = 1; i < values.length; i++)
        {
            if(values[i] < min){
                min = values[i];
            }
        }
        assert min == Arrays.stream(values).min().getAsInt();
        return min;
    }

    public int[] createIntArray(){
        Random generator = new Random();
        int[] array = new int[10000000];
        for(int i = 0; i < 10000000; i++){
            array[i] = generator.nextInt(20000000);
        }
        return array;
    }

    public static void main(String[] args) {
        Example ex = new Example();
        long unixStartTimestamp = System.currentTimeMillis() / 1000L;
        System.out.println(ex.min(ex.createIntArray()));
        long unixEndTimestamp = System.currentTimeMillis() / 1000L;
        System.out.println("Czas " + (unixEndTimestamp - unixStartTimestamp));

    }
}
