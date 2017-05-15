import pl.lab.Lifo;

/**
 * Created by Krszysztof Adamczyk on 08.05.2017.
 */
public class Test {
    public static void main(String[] args) {
        final int MAXFIFOLENGTH = 15;
        Lifo lifo = new Lifo(15);
        for(int i = 0; i < MAXFIFOLENGTH + 2; i++) {
            if(!lifo.isFull()) {
                lifo.push(i*3);
            }
        }
        for(int i = 0; i < MAXFIFOLENGTH + 2; i++) {
            if(!lifo.isEmpty()) {
                System.out.println(lifo.pop());
            }
        }
    }
}
