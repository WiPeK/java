import java.util.*;

/**
 * Created by Acer on 26.03.2017.
 */
public class Example {

    public static void main(String[] args) {
        Set <Integer> a = new TreeSet<>();
        Set <Integer> b = new TreeSet<>();
        for(int i = 0; i < 10; i++) {
            a.add(i);
            b.add(i+5);
        }
        Iterator<Integer> ita = a.iterator();
        System.out.println("First set");
        while(ita.hasNext()) {
            System.out.print(ita.next() + " ");
        }
        System.out.println(System.lineSeparator());
        System.out.println("Second set");
        Iterator<Integer> itb = b.iterator();
        while(itb.hasNext()) {
            System.out.print(itb.next() + " ");
        }

        Set <Integer> sum = new TreeSet<>();
        sum.addAll(a);
        sum.addAll(b);
        System.out.println(System.lineSeparator());
        System.out.println("Sum of first and second set");
        Iterator<Integer> itsum = sum.iterator();
        while(itsum.hasNext()) {
            System.out.print(itsum.next() + " ");
        }

        System.out.println(System.lineSeparator());
        System.out.println("Part of the common of first and second set");
        Set <Integer> common = a;
        common.retainAll(b);
        Iterator<Integer> itcom = common.iterator();
        while(itcom.hasNext()) {
            System.out.print(itcom.next() + " ");
        }

        Set <Integer> e = new TreeSet<>();
        Set <Integer> f = new TreeSet<>();
        Set <Integer> g = new TreeSet<>();
        for(int i = 0; i < 10; i++) {
            e.add(i);
            f.add(i+5);
            g.add(i);
        }
        System.out.println(System.lineSeparator());
        e.removeAll(f);
        Iterator<Integer> ite = e.iterator();
        System.out.println("First set minus second set");
        while(ite.hasNext()) {
            System.out.print(ite.next() + " ");
        }

        System.out.println(System.lineSeparator());
        f.removeAll(g);
        System.out.println("Second set minus first set");
        Iterator<Integer> itf = f.iterator();
        while(itf.hasNext()) {
            System.out.print(itf.next() + " ");
        }

    }
}
