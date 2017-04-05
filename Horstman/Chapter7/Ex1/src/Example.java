import java.util.BitSet;
import java.util.HashSet;

/**
 * Zaimplementuj algorytm sito Eratostenesa, wyznaczający wszystkie liczby pierwsze
 mniejsze od n. Dodaj wszystkie liczby od 2 do n do zestawu. Następnie w pętli
 wyszukuj najmniejszy element s zestawu i usuwaj s^2
 , s*(s+1), s*(s+2) itd. — skończ,
 gdy s^2 > n. Wykonaj to, korzystając z HashSet<Integer> oraz BitSet
 */

class EratosthenesStainer {

    private HashSet<Integer> hSet;

    private BitSet bSet;

    private int n;

    EratosthenesStainer(int n) {
        this.n = n;
        hSet = new HashSet<>(n);
        bSet = new BitSet(n);
        bSet.set(0, n);
        this.fillContainers();
        this.filterElements();
    }

    private void fillContainers() {
        for(int i = 2; i <= n; i++) {
            this.hSet.add(i);
        }
    }

    private void filterElements() {
        for(Integer i = 2; i <= Math.sqrt(this.n); i++) {
            int iCounter = 0;
            for(Integer j = i*i + iCounter; j <= n; j = i*i + i*iCounter) {
                if(j % i == 0) {
                    this.hSet.remove(j);
                    bSet.set(j, false);
                }
                iCounter++;
            }
        }
    }

    public HashSet<Integer> getStainer() {
        return !this.hSet.isEmpty() ? this.hSet : null;
    }

    public BitSet getBitSet() {
        return this.bSet;
    }
}

public class Example {

    public static void main(String[] args) {
        EratosthenesStainer eS = new EratosthenesStainer(100000000);
        for(Integer x: eS.getStainer()) {
            System.out.println(x);
        }
        //System.out.println(eS.getBitSet().toString());
    }
}
