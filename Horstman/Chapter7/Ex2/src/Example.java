import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Acer on 26.03.2017.
 */
public class Example {

    public static void main(String[] args) {
        ArrayList<Character> chAL = new ArrayList<>(5);
        chAL.add('a');
        chAL.add('b');
        chAL.add('c');
        chAL.add('d');
        chAL.add('e');
        ArrayList<Character> chALoop = new ArrayList<>(chAL);
        ArrayList<Character> chRep = new ArrayList<>(chAL);

        Iterator<Character> iter = chAL.iterator();
        while(iter.hasNext()){
            System.out.println(Character.toUpperCase(iter.next()));
        }

        for (Character c: chALoop) {
            c = Character.toUpperCase(c);
            System.out.println(c);
        }

        chRep.replaceAll((e) -> e = Character.toUpperCase(e));
        for(int i = 0; i < chRep.size(); i++) {
            System.out.println(chRep.get(i));
        }

    }
}
