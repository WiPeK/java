import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Acer on 17.03.2017.
 */

class Test{
    private int a;
    private double b;
    private String c;
    public int d;
    public double e;
    public String f;
    protected int g;
    protected double h;
    protected String i;

    public Test(){
        Random r = new Random();
        a = r.nextInt();
        b = r.nextDouble();
        c = "fdasfsdfsdf";
        d = r.nextInt();
        e = r.nextDouble();
        f = "ffvgeragf";
        g = r.nextInt();
        h = r.nextDouble();
        i = "fsdefsdfs";
    }

    public void setA(int a){
        this.a = a;
    }

    public String getC(){
        return this.c;
    }

    public String toString(){
        String s = "";
        try{
            Class<?> cl = Class.forName("Test");
            while (cl != null) {
                for (Method m : cl.getDeclaredMethods()) {
                    s += Modifier.toString(m.getModifiers()) + " " + m.getReturnType().getCanonicalName() + " " + m.getReturnType().getCanonicalName() + " " + m.getName() + " " + Arrays.toString(m.getParameters());
                }
                for(Field f: cl.getFields()){
                    s+= " " + f.getName() + " " + f.getType();
                }
                for(Constructor cs: cl.getConstructors()){
                    s+= " " + cs.getName() + " " + cs.getModifiers() + " " + Arrays.toString(cs.getParameters());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }

    public String intArrayMethodPrinter(){
        Integer[] zz = new Integer[1];
        String s = "";
        try{
            Class<?> cl = Class.forName("Integer[]");
            while (cl != null) {
                for (Method m : cl.getDeclaredMethods()) {
                    s += Modifier.toString(m.getModifiers()) + " " + m.getReturnType().getCanonicalName() + " " + m.getReturnType().getCanonicalName() + " " + m.getName() + " " + Arrays.toString(m.getParameters());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }
}

public class Example {

    public static void main(String[] args) {
        //System.out.println(new Test().toString());
        Test t = new Test();
        System.out.println(t.intArrayMethodPrinter());
    }
}
