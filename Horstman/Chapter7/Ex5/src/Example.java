import java.util.*;

/**
 * Created by Acer on 26.03.2017.
 */
public class Example {

    public static void swap(List<?> list, int i, int j) {
        if(i == j) return;
        if(list instanceof RandomAccess) {
            swapHelp(list, i, j);
        }
        else {
            swapOther(list, i, j);
        }
    }

    private static <T> void swapHelp(List<T> list, int i, int j) {
        T tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    private static <T> void swapOther(List<T> list, int i, int j) {
        T tmp = list.get(i);
        list.add(i, list.get(j));
        list.add(j, tmp);
    }

    public static void main(String[] args) {
        List<Integer> aList = new ArrayList<>();
        List<Integer> lList = new LinkedList<>();

        for(int i = 0; i < 10; i++) {
            aList.add(i);
            lList.add(i);
        }

        swap(aList, 3,7);
        swap(lList, 1,5);

        for(Integer x: aList) {
            System.out.println(x);
        }

        for(Integer x: lList) {
            System.out.println(x);
        }
    }
}
