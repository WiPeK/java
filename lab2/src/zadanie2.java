package zadanie2;
import java.util.Scanner;

public class Zadanie2 {
	static void show(String x){
		int suma =0;
		char ch;
        System.out.println("TEXT:" + x);
        for (int i=0;i<x.length();i++){
            ch = x.charAt(i);
            System.out.println(ch+"	" + Integer.toHexString(ch));
            suma+=ch;
        }
        System.out.println("suma="+ suma);
	}
    public static void main(String[] args) {
        String x = new Scanner(System.in).nextLine();
        show(x);
    }    
}