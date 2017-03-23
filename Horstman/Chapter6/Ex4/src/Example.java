import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Acer on 22.03.2017.
 */

class Table<K, V> {

    private ArrayList<Entry<K, V>> entry = new ArrayList<>();

    public void push(K key, V value) {
        entry.add(new Entry<>(key, value));
    }

    public V getValueByKey(K key) {
        V value = null;
        for(Entry<K, V> x: entry) {
            if(key == x.getKey()) {
                value = x.getValue();
                break;
            }
        }
        return value;
    }

    public void addToKey(K key, V value) {
        for(Entry<K, V> x: entry) {
            if(key == x.getKey()) {
                x.setValue(value);
                break;
            }
        }
    }

    public void deleteByKey(K key) {
        int tmp = 0;
        for(Entry<K, V> x: entry) {
            if(key == x.getKey()) {
                entry.remove(tmp);
                break;
            }
            tmp++;
        }
    }

    public ArrayList<Entry<K, V>> getEntry() {
        return entry;
    }

    class Entry<K, V> implements Map.Entry<K,V> {

        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            this.value = value;
            return value;
        }
    }
}



public class Example {

    public static void main(String[] args) {
        Table<Integer, String> tab = new Table<>();
        for(int i = 0; i < 5; i++) {
            tab.push(i, "value " + Integer.toString(i));
        }

        for(Map.Entry<Integer, String> x: tab.getEntry()) {
            System.out.println("key " + x.getKey() + " " + x.getValue());
        }

        System.out.println("getValueByKey " + tab.getValueByKey(3));
        tab.addToKey(2, "test");
        tab.deleteByKey(3);

        for(Map.Entry<Integer, String> x: tab.getEntry()) {
            System.out.println("key " + x.getKey() + " " + x.getValue());
        }
    }
}
