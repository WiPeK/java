package pl.lab;

import java.util.Arrays;

/**
 * Created by Krszysztof Adamczyk on 08.05.2017.
 */
public class Lifo {

    private Object[] stack = new Object[0];
    private int counter = 0;
    private int maxLength;

    public Lifo(int maxLength) {
        this.maxLength = maxLength;
    }

    public void push(Object element) {
        if(this.counter == this.stack.length){
            this.stack = Arrays.copyOf(this.stack, this.stack.length +1);
        }
        this.stack[this.stack.length-1] = element;
        this.counter++;
    }

    public Object pop() {
        Object element = this.stack[this.stack.length-1];
        this.stack = Arrays.copyOf(this.stack, this.stack.length -1);
        this.counter--;
        return element;
    }

    public boolean isEmpty()
    {
        return this.stack.length == 0;
    }

    public boolean isFull() {
        return this.stack.length == this.maxLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lifo)) return false;

        Lifo lifo = (Lifo) o;

        if (counter != lifo.counter) return false;
        if (maxLength != lifo.maxLength) return false;
        return Arrays.equals(stack, lifo.stack);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(stack);
        result = 31 * result + counter;
        result = 31 * result + maxLength;
        return result;
    }

    @Override
    public String toString() {
        return "Lifo{" +
                "stack=" + Arrays.toString(stack) +
                ", counter=" + counter +
                ", maxLength=" + maxLength +
                '}';
    }
}
