import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

class Stack<E> {

    private E[] stack;
    private int counter = 0;

    public Stack(Class<E> c) {
        try{
            this.stack = (E[])Array.newInstance(c, 0);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void push(E element) {
        if(this.counter == this.stack.length){
            this.stack = Arrays.copyOf(this.stack, this.stack.length +1);
        }
        this.stack[this.stack.length-1] = element;
        this.counter++;
    }

    public E pop() {
        E element = this.stack[this.stack.length-1];
        this.stack = Arrays.copyOf(this.stack, this.stack.length -1);
        this.counter--;
        return element;
    }

    public boolean isEmpty()
    {
        return this.stack.length == 0;
    }
}

class StackObj<E> {

    private Object[] stack = new Object[0];
    private int counter = 0;

    public void push(E element) {
        if(this.counter == this.stack.length){
            this.stack = Arrays.copyOf(this.stack, this.stack.length +1);
        }
        this.stack[this.stack.length-1] = element;
        this.counter++;
    }

    public E pop() {
        E element = (E)this.stack[this.stack.length-1];
        this.stack = Arrays.copyOf(this.stack, this.stack.length -1);
        this.counter--;
        return element;
    }

    public boolean isEmpty()
    {
        return this.stack.length == 0;
    }
}



public class Example {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(Integer.class);
        for(Integer i = 0; i < 100; i++) {
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        StackObj<Integer> stackObj = new StackObj<>();
        for(Integer i = 0; i < 20; i++) {
            stackObj.push(i);
        }

        while(!stackObj.isEmpty()) {
            System.out.println(stackObj.pop());
        }
    }
}
