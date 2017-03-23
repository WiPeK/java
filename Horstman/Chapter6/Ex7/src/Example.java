import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Acer on 23.03.2017.
 */

class Pair<E extends Comparable<E>> {

    private E first;

    private E second;

    public Pair() {}

    public Pair(E first, E second) {
        this.first = first;
        this.second = second;
    }

    public E getFirst() {
        return first;
    }

    public E getSecond() {
        return second;
    }

    public void setFirst(E first) {
        this.first = first;
    }

    public void setSecond(E second) {
        this.second = second;
    }

    public E min() {
        if(this.first.compareTo(this.second) < 0) {
            return this.first;
        }
        else {
            return this.second;
        }
    }

    public E max() {
        if(this.first.compareTo(this.second) > 0) {
            return this.first;
        }
        else {
            return this.second;
        }
    }
}

class Arrays {

    public static <E extends Comparable<E>> Pair<E> firstLast(ArrayList<E> a) {
        if(!a.isEmpty()) {
            return new Pair<E>(a.get(0), a.get(a.size()-1));
        }
        return null;
    }

    public static <E extends Comparable<E>> E min(ArrayList<E> a) {
        if(!a.isEmpty()) {
            E min = a.get(0);
            for(int i = 1; i < a.size(); i++) {
                if(min.compareTo(a.get(i)) > 0) {
                    min = a.get(i);
                }
            }
            return min;
        }
        return null;
    }

    public static <E extends Comparable<E>> E max(ArrayList<E> a) {
        if(!a.isEmpty()) {
            E max = a.get(0);
            for(int i = 1; i < a.size(); i++) {
                if(max.compareTo(a.get(i)) < 0) {
                    max = a.get(i);
                }
            }
            return max;
        }
        return null;
    }

    public static <E extends Comparable<E>> Pair<E> minMax(ArrayList<E> a) {
        if(!a.isEmpty()) {
            return new Pair<E>(Arrays.min(a), Arrays.max(a));
        }
        return null;
    }
}

class Lists {
    public static <T> void minmax(List<T> elements, Comparator<? super T> comp, List<? super T> result) {
        if(!elements.isEmpty()) {
            T min = elements.get(0);
            T max = elements.get(0);
            for(int i = 1; i < elements.size(); i++) {
                if(comp.compare(min, elements.get(i)) > 0) {
                    min = elements.get(i);
                }
                if(comp.compare(max, elements.get(i)) < 0) {
                    max = elements.get(i);
                }
            }
            result.add(min);
            result.add(max);
        }
    }

    public static <T> void maxmin(List<T> elements, Comparator<? super T> comp, List<? super T> result) {
        Lists.minmax(elements, comp, result);
        Lists.swapHelp(result, 0, 1);
    }

    private static <T> void swapHelp(List<T> elementy, int i, int j) {
        T temp = elementy.get(i);
        elementy.set(i, elementy.get(j));
        elementy.set(j, temp);
    }
}

public class Example {

    public static void main(String[] args) {
        Pair<String> p = new Pair<>();
        p.setFirst("aaaaaa");
        p.setSecond("bbbbbb");
        System.out.println(p.min());
        System.out.println(p.max());
        System.out.println("****************");
        ArrayList<Integer> al = new ArrayList<>();
        List<Integer> elements = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            al.add(i);
            elements.add(i);
        }
        Pair<Integer> pp = Arrays.firstLast(al);
        System.out.println("First: " + pp.getFirst() + " last: " + pp.getSecond());
        System.out.println("Min: " + Arrays.min(al));
        System.out.println("Max: " + Arrays.max(al));
        Pair<Integer> ppp = Arrays.minMax(al);
        System.out.println("Min: " + ppp.getFirst() + " max: " + ppp.getSecond());
        System.out.println("****************");
        List<Integer> result = new ArrayList<>(2);
        Lists.minmax(elements, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }, result);
        System.out.println("Min: " + result.get(0) + " max: " + result.get(1));
        List<Integer> res = new ArrayList<>(2);
        Lists.maxmin(elements, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }, res);
        System.out.println("Min: " + res.get(1) + " max: " + res.get(0));
    }
}
