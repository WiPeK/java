import java.util.*;

/**
 * Created by Acer on 27.03.2017.
 */

class Neigbor {

    private String neighborName;

    private double distance;

    Neigbor(String neighborName, double distance) {
        this.neighborName = neighborName;
        this.distance = distance;
    }

    public String getNeighborName() {
        return neighborName;
    }

    public double getDistance() {
        return distance;
    }
}

class Dijkstry {

    public double searchNearest(Map<String, Set<Neigbor>> ms, String source, String destination) {
        final Double INFINITY = Double.MAX_VALUE;
        final Double UNDEFINED = null;

        Double[] distances = new Double[ms.size()];
        Double[] prevs = new Double[ms.size()];
        Queue<Neigbor> queue = new PriorityQueue<>(new Comparator<Neigbor>() {
            @Override
            public int compare(Neigbor o1, Neigbor o2) {
                return (int)o1.getDistance() - (int)o2.getDistance();
            }
        });
        Integer sourceIndex = Integer.parseInt(source);
        distances[sourceIndex] = 0.0;
        for(int i = 0; i < ms.size(); i++) {
            if(i != sourceIndex) {
                distances[i] = INFINITY;
                prevs[i] = UNDEFINED;
            }
            queue.addAll(ms.get(Integer.toString(i)));
        }

        while(!queue.isEmpty()) {
            Neigbor tmp = queue.remove();
            Set<Neigbor> u = ms.get(tmp.getNeighborName());
            for(Neigbor v: u) {
                double alt = distances[Integer.parseInt(v.getNeighborName())] + v.getDistance();
                if(alt < distances[v.getDistance()]) {

                }
            }
        }



        return 0;
    }

}

public class Example {

    public static void main(String[] args) {
        //for point 1
        Set<Neigbor> s1 = new TreeSet<>();
        s1.add(new Neigbor("2", 7));
        s1.add(new Neigbor("3", 9));
        s1.add(new Neigbor("6", 14));
        Map<String, Set<Neigbor>> ms = new TreeMap<>();
        ms.put("1", s1);
        //for point 2
        Set<Neigbor> s2 = new TreeSet<>();
        s2.add(new Neigbor("1", 7));
        s2.add(new Neigbor("3", 10));
        s2.add(new Neigbor("4", 15));
        ms.put("2", s2);
        //for point 3
        Set<Neigbor> s3 = new TreeSet<>();
        s3.add(new Neigbor("1", 9));
        s3.add(new Neigbor("2", 10));
        s3.add(new Neigbor("4", 11));
        s3.add(new Neigbor("6", 2));
        ms.put("3", s3);
        //for point 4
        Set<Neigbor> s4 = new TreeSet<>();
        s4.add(new Neigbor("2", 15));
        s4.add(new Neigbor("3", 11));
        s4.add(new Neigbor("5", 6));
        ms.put("4", s4);
        //for point 5
        Set<Neigbor> s5 = new TreeSet<>();
        s5.add(new Neigbor("4", 6));
        s5.add(new Neigbor("6", 9));
        ms.put("5", s5);
        //for point 6
        Set<Neigbor> s6 = new TreeSet<>();
        s6.add(new Neigbor("1", 14));
        s6.add(new Neigbor("3", 2));
        s6.add(new Neigbor("5", 9));
        ms.put("6", s6);
        Dijkstry dj = new Dijkstry();
        System.out.println(dj.searchNearest(ms, "1", "6"));
    }
}
