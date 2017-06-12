/**
 * Created by Krzysztof Adamczyk on 12.06.2017.
 */
public class Test {

    private int value;

    public synchronized void update(int val) {
        this.value += val;
    }

    public synchronized int getValue() {
        return this.value;
    }

}
