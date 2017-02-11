import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Krzysztof Adamczyk on 11.02.2017.
 * @author Krzysztof Adamczyk
 */

class Menu{
    /**
     * method print menu
     * @return void
     */
    public static void print(){
        System.out.println("1. Addition");
        System.out.println("2. Substraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Show the number of operations");
        System.out.println("6. Exit");
    }
}

/**
 * class management operations in calculator
 */
class Operations{

    /**
     * static field containing the number of made operations
     */
    static int counter = 0;

    /**
     * Operations class constructor
     */
    Operations(){
        super();
    }

    /**
     * @param x,y
     * @return float
     */
    public float addition(float x, float y){
        counter++;
        return x+y;
    }

    /**
     * @param x,y
     * @return float
     */
    public float substraction(float x, float y){
        counter++;
        return x-y;
    }

    /**
     * @param x,y
     * @return float
     */
    public float multiplication(float x, float y){
        counter++;
        return x*y;
    }

    /**
     * @param x,y
     * @return float
     */
    public float division(float x, float y){
        try{
            if (y == 0)
                throw new IllegalArgumentException();
            counter++;
            return x/y;
        }
        catch(IllegalArgumentException e){
                System.out.println("I can't divide by zero");
        }
        return x/y;
    }

    /**
     * @return int
     */
    public static int getCounter(){
        return counter;
    }
}

public class Calculator {
    public static void main(String[] args) throws IOException {
        while (true){
            Menu.print();
            int menu = 6;
            BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
            try{
                menu = Integer.parseInt(rd.readLine());
            }catch (NumberFormatException e){
                System.err.println("Invalid format!");
            }

            if(menu == 6)
            {
                System.out.println("The number of operations is " + Operations.getCounter());
                break;
            }
            if(menu == 5)
            {
                System.out.println("The number of operations is " + Operations.getCounter());
                continue;
            }

            System.out.println("Type first number");
            float x,y;
            try{
                x = Float.parseFloat(rd.readLine());
                System.out.println("Type second number");
                y = Float.parseFloat(rd.readLine());
            }catch (NumberFormatException e){
                System.err.println("Invalid format!");
                continue;
            }
            Operations op = new Operations();
            switch (menu){
                case 1:
                    System.out.println("Addition result " + x + " + " + y + " = " + op.addition(x,y));
                    break;
                case 2:
                    System.out.println("Substraction result " + x + " - " + y + " = " + op.substraction(x,y));
                    break;
                case 3:
                    System.out.println("Multiplication result " + x + " * " + y + " = " + op.multiplication(x,y));
                    break;
                case 4:
                    System.out.println("Division result " + x + " / " + y + " = " + op.division(x,y));
                    break;
                default:
                    continue;
            }
        }
    }
}
