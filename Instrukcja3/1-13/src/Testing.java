import java.util.Random;

/**
 * Created by Krzysztof Adamczyk on 11.02.2017.
 */

class Test{
    public static boolean trueMethod(){
        return true;
    }

    public static boolean falseMethod(){
        return false;
    }
}

public class Testing {
    public static void main(String[] args) {
        Random r = new Random();
        //example2
        int a = r.nextInt() % (1001);
        a++;
        String s = String.format("%d", a);
        System.out.printf("Ex.2 Random value %d, string object %s, int as string %s\n", a, s, a);
        //example3
        String ss = new String("123");
        int b = Integer.parseInt(ss);
        System.out.printf("Ex.3.1 Orginal string %s, string as int (Integer.parseInt) %d\n", ss, b);
        long c = Long.parseLong(ss);
        System.out.printf("Ex.3.2 Orginal string %s, string as long (Long.parseLong) %d%n\n", ss, c);
        float d = Float.parseFloat(ss);
        System.out.printf("Ex.3.3 Orginal string %s, string as float (Float.parseFloat) %f\n", ss, d);
        double e = Double.parseDouble(ss);
        System.out.printf("Ex.3.4 Orginal string %s, string as double (Double.parseDouble) %.2f%n\n", ss, e);
        //example4
        //while loop
        int f = 10;
        while(f >= 0){
            System.out.println("While " + f--);
        }
        int g = 0;
        do{
            System.out.println("do..while " + g++);
        }while(g < 10);

        int[] arr = new int[20];
        for(int i = 0; i < 20; i++){
            System.out.println("For " + i);
            arr[i] = r.nextInt() % (1001);
        }
        //example5
        for (int j:
             arr) {
            System.out.println("Foreach " + j);
        }
        //example6
        boolean k = true;
        System.out.println(k + " " + (k? "prawda" : "fałsz"));
        //example7
        System.out.println("Break w petlach przerywa działanie pętli, w switch kończy warunek gdzie ma case zakończyć się wykonywać");
        System.out.println("Continue w pętlach pozwala na kontunuacje pętli od następnej iteracji");
        //example8
        outLoop: for(int l = 0; l < 10; l++){
            inLoop: for(int m = 0; m < 10; m++){
                switch (l){
                    case 1:
                        continue inLoop;
                    case 2:
                        break inLoop;
                    case 3:
                        continue outLoop;
                    case 4:
                        break outLoop;
                }
            }
        }
        //example9
        int n = 10;
        int o = 20;
        System.out.println(n + "!=" + o + "=" + (n!=o));
        boolean p = true;
        boolean t = false;
        System.out.println(p + "&&" + t + "=" + (p&&t));
        System.out.println(p + "||" + t + "=" + (p||t));
        int u = 1;
        int v = 0;
        System.out.println(u + "&" + v + "=" + (u&v));
        System.out.println(u + "|" + v + "=" + (u|v));
        u = 20;
        System.out.println(u + "<< =" + (u<<1));
        u=20;
        System.out.println(u + ">> =" + (u>>1));
        u=20;
        System.out.println(u + ">>> =" + (u>>>1));
        u=20;
        System.out.println("~" + u + " =" + (~u));
        //example10
        System.out.println("Priority of operators: . [] () ++ -- ~ ! instanceof new * / % + - << >> >>> < > <= >= == != & ^ | && || ?: =");
        //example11
        Integer w = 10;
        int x = 10;
        System.out.println("Integer " + w + " int " + x + " == " + (w==x));
        System.out.println("Integer " + w + " int " + x + " equals " + (w.equals(x)));
        //example12
        int ab = 10;
        float ac = (float)ab;
        double ad = (double)ac;
        String ae = "123";
        int af = Integer.parseInt(ae);
        System.out.println("int " + ab + " float from int " + ac + " double from float " + ad + " int from string " + af);
        //example13
        if(Test.trueMethod()){
            System.out.println("Method return true");
        }else{
            System.out.println("Method return false");
        }
        if(Test.falseMethod()){
            System.out.println("Method return true");
        }else{
            System.out.println("Method return false");
        }

    }
}
