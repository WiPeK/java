import java.util.ArrayList;

/**
 * Created by Acer on 22.03.2017.
 */

class Stack<E> {

    private ArrayList<E> stack = new ArrayList<>();

    public void push(E element) {
        this.stack.add(element);
    }

    public E pop() {
        E element = this.stack.get(this.stack.size() -1);
        this.stack.remove(this.stack.size() -1);
        return element;
    }

    public boolean isEmpty()
    {
        return this.stack.isEmpty();
    }
}

public class Example {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < 10; i++) {
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
